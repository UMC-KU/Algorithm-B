//22.04.02
/*
1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
 */
//문자열 계속 쌓을땐 String보다는 StringBuilder를 사용하자

package data_structure;

import java.io.*;
import java.util.ArrayList;

public class BJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(0,0);
        int top=0, index=1;
        boolean flag=true;
        StringBuilder result = new StringBuilder();
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (stack.get(top)>num) {
                flag=false;
                break;
            }
            while (stack.get(top)<num) {
                stack.add(top+1, index);
                index++;
                top++;
                result.append("+\n");
            }
            if (stack.get(top)==num) {
                stack.remove(top);
                top--;
                result.append("-\n");
            }
        }

        if (!flag) {
            bw.write("NO");
        } else {
            bw.write(result.toString());
        }
        bw.flush();
        bw.close();
    }
}
