import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;
/**
 * 136ms
 * */
public class BJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String calcul = br.readLine();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<N; i++) {
            map.put((char)('A'+i),Integer.parseInt(br.readLine()));
        }


        char[] strInput = calcul.toCharArray();

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i<strInput.length; i++) {
            if(strInput[i] >= 'A' && strInput[i] <= 'Z') {
                stack.push((double)map.get(strInput[i]));
            }else{
                double second = stack.pop();
                double first = stack.pop();
                switch (strInput[i]) {
                    case '+':
                        stack.push(first+second);
                        break;
                    case '-':
                        stack.push(first-second);
                        break;
                    case '*':
                        stack.push(first*second);
                        break;
                    case '/':
                        stack.push(first/second);
                        break;
                }
            }
        }
        System.out.printf("%.2f",stack.pop());
    }
}
