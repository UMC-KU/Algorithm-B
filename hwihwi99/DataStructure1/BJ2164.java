import java.util.*;
import java.util.Queue;
/**
 * 280ms
 * */
public class BJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i<N;i++) {
            queue.offer(i+1);
        }

        while (queue.size()!=1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
