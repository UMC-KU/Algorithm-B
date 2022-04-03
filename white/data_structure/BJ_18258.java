//22.03.31
/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
//arraylist의 remove/add 이용해서 시간초과
// --> arraylist에서 copy 연산이 일어나지 않게 front와 back을 이용해서 queue 나타내고 값을 remove하지 않음
//      + switch case 사용

package data_structure;

import java.io.*;
import java.util.ArrayList;

public class BJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> queue = new ArrayList<>();

        String input;
        int size;
        int front=0;
        int back=0;
        for (int i=0; i<n; i++) {
            input = br.readLine();
            size = back-front;

            if(input.contains("push")) {
                int push = Integer.parseInt(input.split(" ")[1]);
                queue.add(back, push);
                back++;
            } else {
                switch (input) {
                    case "pop":
                        if (size == 0) {
                            bw.write("-1\n");
                        } else {
                            bw.write(queue.get(front) + "\n");
                            front++;
                        }
                        break;
                    case "size":
                        bw.write(size + "\n");
                        break;
                    case "empty":
                        if (size == 0) {
                            bw.write("1\n");
                        } else {
                            bw.write("0\n");
                        }
                        break;
                    case "front":
                        if (size == 0) {
                            bw.write("-1\n");
                        } else {
                            bw.write(queue.get(front) + "\n");
                        }
                        break;
                    default:
                        if (size == 0) {
                            bw.write("-1\n");
                        } else {
                            bw.write(queue.get(back-1) + "\n");
                        }
                        break;
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
