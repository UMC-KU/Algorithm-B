//22.04.03
/*
현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면,
이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.

각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력한다.
 */

package data_structure;

import java.io.*;

public class BJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            int[] prio = new int[10];
            String[] input1 = br.readLine().split(" ");
            int num = Integer.parseInt(input1[0]);
            int index = Integer.parseInt(input1[1]);

            int[] doc = new int[num];
            String[] arr = br.readLine().split(" ");
            for (int j=0; j<num; j++) {
                int p = Integer.parseInt(arr[j]);
                doc[j] = p;
                prio[p]++;
            }

            int result=1, top=0;
            for (int j=9; j>0; j--) {
                while (prio[j]>0) {
                    while (doc[top]!= j) {
                        top = (++top)%num;
                    }
                    prio[j]--;
                    if (top==index) {
                        for (int k=j; k>0; k--){
                            prio[k]=0;
                        }
                        break;
                    }
                    result++;
                    top = (++top)%num;
                }
            }

            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}
