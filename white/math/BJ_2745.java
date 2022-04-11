//22.04.10
/*
B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 */

package math;

import java.io.*;

public class BJ_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int b = Integer.parseInt(input[1]);
        int result=0;

        for (int i=input[0].length()-1; i>=0; i--) {
            int c = input[0].charAt(i);
            if (c>='A') {
                c-='A'-10;
            } else if(c>='0') {
                c-='0';
            }
            int n = (int)Math.pow(b, input[0].length()-i-1);
            result+= c*n;
        }
        System.out.println(result);
    }
}
