import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


// 해결 못함.. nullpoint...
public class BJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> input = new LinkedList<>();

        for(int i = 0; i<N; i++) {
            input.offer(Integer.parseInt(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        int A = input.peek();
        Stack<Integer> stack = new Stack<>();

        int i = 1;

        while(i<=N) {
            if(i < A) {
                stack.push(i);
                sb.append('+').append('\n');
                i++;
            } else if(i == A) {
                stack.push(i);
                sb.append('+').append('\n');
                stack.pop();
                sb.append('-').append('\n');
                input.poll();
                A = input.peek();
                i++;
            } else if(i > A) {
                if(stack.pop() == A) {
                    sb.append('-').append('\n');
                    input.poll();
                    A = input.peek();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        while (!input.isEmpty()) {
            A = input.peek();
            if(stack.pop() == A) {
                sb.append('-').append('\n');
                input.poll();
            } else {
                System.out.println("NO");
                return;
            }
        }


        System.out.println(sb);

    }
}
