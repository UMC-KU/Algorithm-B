import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 163ms
 *
 * 리얼 엄청 오래 걸림.....-> 다시해보기....
 *
 * */
public class BJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Queue<Info> queue = new LinkedList<>();

        for(int i = 0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                queue.add(new Info(j,temp));
            }
            int result = 1;

            while (!queue.isEmpty()) {
                Info info = queue.poll();
                boolean check = true;

                Iterator it = queue.iterator();
                while (it.hasNext()) {
                    Info f = (Info) it.next();
                    if(info.priority < f.priority) { // 나보다 큰 우선순위가 있으면 나는 나오면 안된다.
                        check = false;
                        break;
                    }
                }

                if(check == false) {
                    queue.add(info);
                }else {
                    if(info.idx == M) {
                        System.out.println(result);
                    } else {
                        result++;
                    }
                }



            }
        }
    }
}

class Info{
    int idx;
    int priority;

    public Info(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}
