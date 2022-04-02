//22.04.02

package data_structure;

import java.io.*;

public class BJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        boolean flag = false;
        int len = input.length();
        int result = 0, count = 0;
        for(int i=0; i<len; i++) {
            if (input.charAt(i) == '(') {
                if (!flag) {
                    flag=true;
                } else {
                    result++;
                    count++;
                }
            } else if (input.charAt(i) == ')') {
                if (flag) {
                    result += count;
                    flag = false;
                } else {
                    count--;
                }
            }
        }
        System.out.println(result);
    }
}
