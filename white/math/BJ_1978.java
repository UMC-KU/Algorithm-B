//22.04.10
/*
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 */

package math;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] numArr = new int[n];
        for (int i=0; i<n; i++) {
            numArr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(numArr);
        ArrayList<Integer> prime = new ArrayList<>();
        prime.add(2);
        for (int i=3; i<=numArr[n-1]; i+=2) {
            boolean flag=true;
            for (int j:prime){
                if (i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag) {
                prime.add(i);
            }
        }

        int i=0, j=0, count=0;
        while (i<n && j<prime.size()) {
            if (numArr[i]>prime.get(j)) {
                j++;
            } else if (numArr[i]<prime.get(j)) {
                i++;
            } else {
                count++;
                i++;
                j++;
            }
        }
        System.out.println(count);
    }
}
