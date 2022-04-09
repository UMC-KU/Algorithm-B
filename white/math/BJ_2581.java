//22.04.10
/*
자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라
이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중
소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로,
이들 소수의 합은 620이고, 최솟값은 61이 된다.
 */

package math;

import java.io.*;
import java.util.ArrayList;

public class BJ_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int min = Integer.parseInt(br.readLine());
        int max = Integer.parseInt(br.readLine());

        ArrayList<Integer> prime = new ArrayList<>();
        boolean flag = true;
        boolean minFlag = true;
        int minResult=0, minCount=0;
        for (int i=2; i<=max; i+=2) {
            for (int j:prime) {
                if (i%j==0) {
                    flag=false;
                    break;
                }
            }
            if (flag) {
                prime.add(i);
                if (i>=min && minFlag) {
                    minFlag=false;
                    minResult = i;
                    minCount = prime.size()-1;
                }
            }
            flag=true;
            if (i==2) {
                i--;
            }
        }
        int sum=0;
        for (int i=minCount; i<prime.size(); i++) {
            sum+= prime.get(i);
        }

        if (minFlag) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minResult);
        }
    }
}
