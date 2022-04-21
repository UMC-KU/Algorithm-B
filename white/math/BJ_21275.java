//22.04.21
/*
먼저 폰 호석만은 수 3개 X, A, B를 결정한다(0 ≤ X < 263, 2 ≤ A ≤ 36, 2 ≤ B ≤ 36, A ≠ B). 이 때 X는 10진법이다.
그 다음에 X를 A진법으로 표현한 수와 B진법으로 표현한 수를 종이에 써 놓는다.
그 다음에 종이에 써져 있는 두 개의 수를 여러분에게 보여주게 된다. 주어진 두 개의 수를 통해 원래 숫자인 X, A, B를 계산해주자.
만약 조건을 만족하는 (X, A, B)로 가능한 조합이 여러 개라면 "Multiple"을 출력하고, 가능한 조합이 없다면 "Impossible"를 출력한다.
 */

package math;

import java.io.*;

public class BJ_21275 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int[] num1 = new int[s[0].length()];
        int[] num2 = new int[s[1].length()];
        int max1=0, max2=0;
        for (int i=0; i<s[0].length(); i++) {
            int index=s[0].length()-i-1;
            if(s[0].charAt(i)>='a') {
                num1[index] = s[0].charAt(i)-'a'+10;
            } else {
                num1[index] = s[0].charAt(i)-'0';
            }
            if (max1<num1[index]) {
                max1 = num1[index];
            }
        }
        for (int i=0; i<s[1].length(); i++) {
            int index=s[1].length()-i-1;
            if(s[1].charAt(i)>='a') {
                num2[index] = s[1].charAt(i)-'a'+10;
            } else {
                num2[index] = s[1].charAt(i)-'0';
            }
            if (max2<num2[index]) {
                max2 = num2[index];
            }
        }

        long[] result = new long[37];
        for (int i=max1+1; i<37; i++) {
            for (int j=0; j<num1.length; j++) {
                result[i]+= num1[j]*Math.pow(i, j);
                if (result[i]>=Math.pow(2, 63)){
                    result[i]=0;
                    break;
                }
            }
        }
        int flag=0;
        long resultX=0;
        int resultA=0, resultB=0;
        for (int i=max2+1; i<37; i++) {
            long resultNum=0;
            for (int j=0; j<num2.length; j++){
                resultNum+= num2[j]*Math.pow(i, j);
            }

            for (int j=max1+1; j<37; j++) {
                if (result[j]==resultNum && i!=j) {
                    flag++;
                    resultX = resultNum;
                    resultA = j;
                    resultB = i;
                }
            }
        }

        if (flag==0) {
            bw.write("Impossible");
        } else if (flag==1) {
            bw.write(resultX+" "+resultA+" "+resultB);
        } else {
            bw.write("Multiple");
        }
        bw.flush();
        bw.close();
    }
}
