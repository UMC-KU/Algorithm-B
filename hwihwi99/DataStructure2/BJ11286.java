import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Data{
    int absolute;
    int origin;
}
public class BJ11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Data> priorityQueue = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if(o2.absolute > o1.absolute) {
                    return -1;
                } else if(o2.absolute < o1.absolute) {
                    return 1;
                } else {
                    if(o1.origin<o2.origin) {
                        return -1;
                    } else if(o1.origin>o2.origin) {
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        for(int i = 0; i<N; i++) {
            int T = sc.nextInt();
            if(T == 0) {
                if(priorityQueue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(priorityQueue.poll().origin).append("\n");
                }
            }else{
                Data data = new Data();
                if(T < 0) {
                    data.absolute = -1 * T;
                    data.origin = T;
                } else {
                    data.absolute = T;
                    data.origin = T;
                }
                priorityQueue.offer(data);
            }
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        System.out.println(sb);
    }
}
