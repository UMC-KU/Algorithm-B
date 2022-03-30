//22.03.31
/*
입력으로 주어진 괄호 문자열이 VPS(올바른 괄호 문자열)인지 아닌지를 판단해서
그 결과를 YES 와 NO 로 나타내어야 한다.
 */

package data_structure;

import java.io.*;

public class BJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input;
        int len, top;
        for (int i=0; i<n; i++){
            input = br.readLine();
            len = input.length();
            top=-1;
            for (int j=0; j<len; j++){
                if(input.charAt(j)=='(') {
                    top++;
                } else if(input.charAt(j)==')') {
                    top--;
                }

                if (top<-1) {
                    break;
                }
            }
            if (top==-1){
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
