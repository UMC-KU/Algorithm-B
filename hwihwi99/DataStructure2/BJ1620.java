import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer,String> hashMapNum = new HashMap<>();
        HashMap<String,Integer> hashMapString = new HashMap<>();
        for(int i = 1; i<=N; i++) {
            String name = br.readLine();
            hashMapNum.put(i,name);
            hashMapString.put(name,i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M; i++) {
            String input = br.readLine();
            try{
                int Mnum = Integer.parseInt(input);
                sb.append(hashMapNum.get(Mnum)).append("\n");
            } catch(NumberFormatException e) {
                sb.append(hashMapString.get(input)).append("\n");
            }
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        System.out.println(sb);
    }
}
