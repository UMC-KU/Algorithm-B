import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ14425 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i<N; i++) {
            hashSet.add(br.readLine());
        }
        int answer = 0;
        for(int i = 0; i<M; i++) {
            String input = br.readLine();
            if(hashSet.contains(input)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
