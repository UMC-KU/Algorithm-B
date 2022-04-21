//22.04.21
/*
첫 번째 줄에 입력될 수들의 개수 N이 주어진다.
두 번째 줄에는 수열 A를 이루는 자연수 A[i]가 공백으로 구분되어 주어진다.
수열 A에 X와 서로소인 수가 최소 1개 이상 존재한다.
마지막 줄에는 X가 주어진다.

수열 A에서 X와 서로소인 수들의 평균을 출력한다.
 */

package math;

import java.io.*;
import java.text.DecimalFormat;

public class BJ_21920 {
    static int gcd(int a, int b) {
        int r = a%b;
        if (r==0) {
            return b;
        } else {
            return gcd(b, r);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] array = new int[n];
        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(s[i]);
        }
        int x = Integer.parseInt(br.readLine());

        double sum=0, count=0;
        for (int i=0; i<n; i++) {
            if (gcd(Math.max(x, array[i]), Math.min(x, array[i]))==1) {
                sum+=array[i];
                count++;
            }
        }
        DecimalFormat df = new DecimalFormat("#.######");

        bw.write(df.format(sum/count));
        bw.close();
    }
}
