import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> treeHashMap = new HashMap<>();

        String input = br.readLine();
        int count = 0;
        while (true) {
            count ++;
            if(treeHashMap.containsKey(input)) {
                int tmp = treeHashMap.get(input);
                treeHashMap.put(input, tmp + 1);
            } else {
                treeHashMap.put(input,1);
            }
            input = br.readLine();
            if(input == null || input.length() == 0) {
                break;
            }
        }

        Object[] mapKey = treeHashMap.keySet().toArray(new String[0]);
        Arrays.sort(mapKey);

        for(Object o : mapKey) {
            double percent = (double) (treeHashMap.get(o) * 100) / count;
            System.out.printf("%s %.4f\n" , o, percent);
        }

    }
}
