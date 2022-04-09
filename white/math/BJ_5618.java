package math;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_5618 {
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
        String[] str = br.readLine().split(" ");
        int[] num = new int[str.length];
        for (int i=0; i<str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(num);

        int gcd = gcd(num[1], num[0]);
        if (n>2) {
            gcd = gcd(num[2], gcd);
        }

//        ArrayList<Integer> result = new ArrayList();
        int count=0, i=1;
        for (i=1; i<=gcd; i++) {
            if (gcd%i==0) {
                bw.write(i+"\n");
//                result.add(count,i);
//                result.add(++count, gcd/i);
            }
        }
//        if (gcd%i==0) {
//            result.add(count, i);
//        }
//
//        for (int j:result) {
//            bw.write(j+"\n");
//        }
        bw.flush();
        bw.close();
    }
}
