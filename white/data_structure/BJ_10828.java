//22.03.31
/*
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
//arraylist 대신 array 사용 : 228ms -> 220ms

package data_structure;

import java.io.*;

public class BJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] stack = new String[n];
        int size=0;

        for (int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");

            if (input[0].equals("push")) {
                stack[size] = input[1];
                size++;
            }else if (input[0].equals("pop")) {
                if(size==0){
                    bw.write("-1\n");
                } else {
                    bw.write(stack[size-1]+"\n");
                    size--;
                }
            } else if(input[0].equals("size")) {
                bw.write(size+"\n");
            } else if(input[0].equals("empty")) {
                if (size==0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (input[0].equals("top")) {
                if(size==0) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack[size-1]+"\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
