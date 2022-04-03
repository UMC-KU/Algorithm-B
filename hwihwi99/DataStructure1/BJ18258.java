import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 1412ms
 * */
public class BJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i<N; i++) {
            String cmd = br.readLine();

            if(cmd.contains("push")) {
                st = new StringTokenizer(cmd);
                st.nextToken();
                int X = Integer.parseInt(st.nextToken());
                queue.addLast(X);
            }else if(cmd.equals("pop")) {
                if(queue.isEmpty())
                    builder.append(-1).append("\n");
                else
                    builder.append(queue.pollFirst()).append("\n");
            } else if(cmd.equals("size")) {
                builder.append(queue.size()).append("\n");
            } else if(cmd.equals("empty")) {
                if(queue.isEmpty())
                    builder.append(1).append("\n");
                else
                    builder.append(0).append("\n");
            } else if(cmd.equals("front")) {
                if(queue.isEmpty())
                    builder.append(-1).append("\n");
                else
                    builder.append(queue.peekFirst()).append("\n");
            } else if(cmd.equals("back")) {
                if(queue.isEmpty())
                    builder.append(-1).append("\n");
                else
                    builder.append(queue.peekLast()).append("\n");
            }
        }
        builder.deleteCharAt(builder.lastIndexOf("\n"));
        System.out.println(builder);
    }
}
