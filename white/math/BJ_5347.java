//22.04.10
/*
두 수 a와 b가 주어졌을 때, a와 b의 최소 공배수를 구하는 프로그램을 작성하시오.
 */

package math;

import java.io.*;

public class BJ_5347 {
    static int gcd(int a, int b) {
        if (a%b==0) {
            return b;
        } else {
            return gcd(b, a%b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            int num1 = Integer.parseInt(str[0]);
            int num2 = Integer.parseInt(str[1]);

            if (num1>=num2) {
                bw.write((long)num1*num2/gcd(num1, num2)+"\n");
            } else {
                bw.write((long)num1*num2/gcd(num2, num1)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}