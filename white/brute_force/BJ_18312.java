//22.05.09
/*
정수 N과 K가 입력되었을 때 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서
K가 하나라도 포함되는 모든 시각을 세는 프로그램을 작성하시오.
시각을 셀 때는 디지털 시계를 기준으로, 초 단위로만 시각을 구분한다.
 */

package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_18312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int oneHourTotal = 60*60;
        int oneHourCount;
        if (k<6) {
            oneHourCount = 15*60 + 45*15;
        } else {
            oneHourCount = 6*60 + 54*6;
        }

        int result=0;
        for (int i=0; i<=n; i++) {
            int n1 = i/10;
            int n2 = i%10;
            if (n1==k || n2==k) {
                result += oneHourTotal;
            } else {
                result += oneHourCount;
            }
        }

        System.out.println(result);
    }
}
