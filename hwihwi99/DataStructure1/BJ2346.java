import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Balloon {
    int num;
    int paper;
    public Balloon(int num, int paper) {
        this.num = num;
        this.paper = paper;
    }
}

public class BJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();

        for(int i = 1; i <=N; i++) {
            Balloon balloon = new Balloon(i,Integer.parseInt(st.nextToken()));
            deque.addLast(balloon);
        }

        Balloon ballon = deque.removeFirst();
        StringBuilder sb = new StringBuilder();
        sb.append(ballon.num).append(' ');
        int move = ballon.paper;

        while (!deque.isEmpty()) {
            if(move < 0) {
                move *= -1;
                for(int j = 0; j<move; j++) {
                    deque.addFirst(deque.removeLast());
                }
                Balloon b = deque.removeFirst();
                move = b.paper;
                sb.append(b.num).append(' ');
            } else {
                for(int j = 0; j<move; j++) {
                    deque.addLast(deque.removeFirst());
                }
                Balloon b = deque.removeLast();
                move = b.paper;
                sb.append(b.num).append(' ');
            }
        }

        sb.deleteCharAt(sb.lastIndexOf(" "));
        System.out.println(sb);
    }
}
