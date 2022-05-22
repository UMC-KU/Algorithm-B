//22.05.22
/*
Hamming Distance란 길이가 같은 두 DNA가 있을 때, 각 위치의 뉴클오티드 문자가 다른 것의 개수이다.
만약에 “AGCAT"와 ”GGAAT"는 첫 번째 글자와 세 번째 글자가 다르므로 Hamming Distance는 2이다.
 N개의 길이 M인 DNA s1, s2, ..., sn가 주어져 있을 때 Hamming Distance의 합이 가장 작은 DNA s를 구하는 것이다.
 즉, s와 s1의 Hamming Distance + s와 s2의 Hamming Distance + s와 s3의 Hamming Distance ... 의 합이 최소가 된다는 의미이다.
 */

package brute_force;

import java.io.*;

public class BJ_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] dna = new String[n];
        for (int i=0; i<n; i++) {
            dna[i] = br.readLine();
        }

        int[][] count = new int[m][20];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                count[j][dna[i].charAt(j)-'A']++;
            }
        }

        char[] list = {'A', 'C', 'G', 'T'};
        int totalDist=0;
        char[] result = new char[m];
        for (int i=0; i<m; i++) {
            int max = 0;
            char maxC = 'A';
            for (int j=0; j<4; j++) {
                if (count[i][list[j]-'A']>max) {
                    max = count[i][list[j]-'A'];
                    maxC = list[j];
                }
            }

            totalDist+=(n-max);
            result[i] = maxC;
        }

        for(char c:result) {
            bw.write(c);
        }
        bw.write("\n");
        bw.write(totalDist+"\n");
        bw.flush();
        bw.close();
    }
}
