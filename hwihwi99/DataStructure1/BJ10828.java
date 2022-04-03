import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 192ms
 * */
public class BJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<N; i++) {
            String cmd = br.readLine();

            if(cmd.contains("push")) {
                st = new StringTokenizer(cmd);
                st.nextToken();
                int X = Integer.parseInt(st.nextToken());
                stack.push(X);
            }else if(cmd.equals("pop")) {
                if(stack.isEmpty())
                    builder.append(-1).append("\n");
                else
                    builder.append(stack.pop()).append("\n");
            } else if(cmd.equals("size")) {
                builder.append(stack.size()).append("\n");
            } else if(cmd.equals("empty")) {
                if(stack.isEmpty())
                    builder.append(1).append("\n");
                else
                    builder.append(0).append("\n");
            } else if(cmd.equals("top")) {
                if(stack.isEmpty())
                    builder.append(-1).append("\n");
                else
                    builder.append(stack.peek()).append("\n");
            }
        }
        builder.deleteCharAt(builder.lastIndexOf("\n"));
        System.out.println(builder);
    }
}
