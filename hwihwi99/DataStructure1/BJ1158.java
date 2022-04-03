import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 712ms
 * */

public class BJ1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<N; i++) {
            queue.offer(i+1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('<');

        while (!queue.isEmpty()) {

            for(int j = 0; j<K-1; j++) {
                queue.offer(queue.poll());
            }
            stringBuilder.append(queue.poll()).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));

        stringBuilder.append('>');
        System.out.println(stringBuilder);
    }
}
