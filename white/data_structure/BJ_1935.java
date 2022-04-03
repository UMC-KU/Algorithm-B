//22.04.02
/*
후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.
 */

package data_structure;

import java.io.*;

public class BJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int[] value = new int[n];
        for (int i=0; i<n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        int len=input.length();
        double[] stack = new double[len];
        int top=0;
        for (int i=0; i<len; i++) {
            char c = input.charAt(i);
            if (c>='A' && c<='Z') {
                stack[top] = (double)value[c-'A'];
                top++;
            } else {
                double op1 = stack[--top];
                double op2 = stack[--top];

                switch (c) {
                    case '+':
                        stack[top++] = op1+op2;
                        break;
                    case '-':
                        stack[top++] = op2-op1;
                        break;
                    case '*':
                        stack[top++] = op1*op2;
                        break;
                    case '/':
                        stack[top++] = op2/op1;
                }
            }
        }
        String result = String.format("%.2f", stack[0]);
        bw.write(result);
        bw.flush();
        bw.close();
    }
}
