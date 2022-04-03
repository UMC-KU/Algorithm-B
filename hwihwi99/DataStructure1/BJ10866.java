import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 204ms
 * */
public class BJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> dequeue = new ArrayDeque<>();
        for(int i = 0; i<N; i++) {
            String cmd = br.readLine();

            if(cmd.contains("push_front")) {
                st = new StringTokenizer(cmd);
                st.nextToken();
                int X = Integer.parseInt(st.nextToken());
                dequeue.addFirst(X);
            } else if(cmd.contains("push_back")) {
                st = new StringTokenizer(cmd);
                st.nextToken();
                int X = Integer.parseInt(st.nextToken());
                dequeue.addLast(X);
            } else if(cmd.equals("pop_front")) {
                if(dequeue.isEmpty())
                    builder.append(-1).append("\n");
                else
                    builder.append(dequeue.pollFirst()).append("\n");
            } else if(cmd.contains("pop_back")) {
                if(dequeue.isEmpty())
                    builder.append(-1).append("\n");
                else
                    builder.append(dequeue.pollLast()).append("\n");
            } else if(cmd.equals("size")) {
                builder.append(dequeue.size()).append("\n");
            } else if(cmd.equals("empty")) {
                if(dequeue.isEmpty())
                    builder.append(1).append("\n");
                else
                    builder.append(0).append("\n");
            } else if(cmd.equals("front")) {
                if(dequeue.isEmpty())
                    builder.append(-1).append("\n");
                else
                    builder.append(dequeue.peekFirst()).append("\n");
            } else if(cmd.equals("back")) {
                if(dequeue.isEmpty())
                    builder.append(-1).append("\n");
                else
                    builder.append(dequeue.peekLast()).append("\n");
            }
        }
        builder.deleteCharAt(builder.lastIndexOf("\n"));
        System.out.println(builder);
    }
}
