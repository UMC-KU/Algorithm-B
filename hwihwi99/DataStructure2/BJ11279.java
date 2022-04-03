import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ11279 {
    public static void main(String[] args) {
        // Collections.reverseOrder() -> 최대힙으로 만드는 방법!!
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++) {
            int T = sc.nextInt();
            if(T == 0 && priorityQueue.isEmpty()) {
                sb.append(0).append("\n");
            } else if(T==0) {
                sb.append(priorityQueue.poll()).append("\n");
            } else {
                priorityQueue.offer(T);
            }
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        System.out.println(sb);
    }
}
