import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * 128ms
 * */
public class BJ9012 {
    private static Stack<Character> stack;
    public static Boolean check(String str) {
        char[] input = str.toCharArray();

        for(char c : input) {
            if(c=='(')
                stack.push(c);
            else if(c==')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<N; i++) {
            stack = new Stack<>();
            if(check(br.readLine()))
                builder.append("YES").append("\n");
            else
                builder.append("NO").append("\n");
        }
        builder.deleteCharAt(builder.lastIndexOf("\n"));
        System.out.println(builder);
    }
}
