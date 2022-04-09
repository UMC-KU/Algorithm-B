//22.04.10
/*
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 */

package math;

import java.io.*;

public class BJ_2609 {
    static int gcd(int n1, int n2){
        int r = n1%n2;
        if (r==0) {
            return n2;
        } else {
            return gcd(n2, r);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);

        int gcd;
        if (num1>num2) {
            gcd = gcd(num1, num2);
        } else {
            gcd = gcd(num2, num1);
        }
        int lcm = num1*num2/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
