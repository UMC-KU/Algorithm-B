//22.04.02
/*
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

package data_structure;

import java.io.*;
import java.util.ArrayList;

public class BJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> front_deque = new ArrayList<>();
        ArrayList<Integer> back_deque = new ArrayList<>();

        int[] front = {1,0};
        int[] back = {1,0};
        String input;
        String[] inputs = new String[2];
        for (int i=0; i<n; i++){
            input = br.readLine();
            if (input.contains("push")) {
                inputs = input.split(" ");
                input= inputs[0];
            }
            switch (input) {
                case "push_front":
                    if(front[0]==0) {
                        front_deque.add(front[1], Integer.parseInt(inputs[1]));
                        front[1]++;
                    } else if (front[1]==0) {
                        front_deque.add(0, Integer.parseInt(inputs[1]));
                        front[0]=0;
                        front[1]=1;
                    } else {
                        front[1]--;
                        back_deque.set(front[1], Integer.parseInt(inputs[1]));
                    }
                    break;
                case "push_back":
                    if(back[0]==1) {
                        back_deque.add(back[1], Integer.parseInt(inputs[1]));
                        back[1]++;
                    } else if (back[1]==1) {
                        front_deque.set(0, Integer.parseInt(inputs[1]));
                        back[0]=1;
                        back[1]=0;
                    } else {
                        back[1]--;
                        front_deque.set(back[1], Integer.parseInt(inputs[1]));
                    }
                    break;
                case "pop_front":
                    if (front[0]==back[0] && front[1]==back[1]) {
                        bw.write("-1\n");
                    } else if(front[0]==1) {
                        bw.write(back_deque.get(front[1])+"\n");
                        front[1]++;
                    } else if (front[1]==1) {
                        bw.write(front_deque.remove(0)+"\n");
                        front[0]=1;
                        front[1]=0;
                    } else {
                        front[1]--;
                        bw.write(front_deque.remove(front[1])+"\n");
                    }
                    break;
                case "pop_back":
                    if (front[0]==back[0] && front[1]==back[1]) {
                        bw.write("-1\n");
                    } else if(back[0]==0) {
                        bw.write(front_deque.get(back[1])+"\n");
                        back[1]++;
                    } else if (back[1]==0) {
                        bw.write(front_deque.get(0)+"\n");
                        back[0]=0;
                        back[1]=1;
                    } else {
                        back[1]--;
                        bw.write(back_deque.remove(back[1])+"\n");
                    }
                    break;
                case "size":
                    if (front[0]!=back[0]) {
                        bw.write(back[1]+front[1]+"\n");
                    } else if (front[0]==1){
                        bw.write(back[1]-front[1]+"\n");
                    } else {
                        bw.write(front[1]-back[1]+"\n");
                    }
                    break;
                case "empty":
                    if (front[0]==back[0] && front[1]==back[1]) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (front[0]==back[0] && front[1]==back[1]) {
                        bw.write("-1\n");
                    } else if(front[0]==0) {
                        bw.write(front_deque.get(front[1]-1)+"\n");
                    } else {
                        bw.write(back_deque.get(front[1])+"\n");
                    }
                    break;
                case "back":
                    if (front[0]==back[0] && front[1]==back[1]) {
                        bw.write("-1\n");
                    } else if (back[0]==0) {
                        bw.write(front_deque.get(back[1])+"\n");
                    } else if(back[1]==0){
                        bw.write(front_deque.get(0)+"\n");
                    } else {
                        bw.write(back_deque.get(back[1]-1)+"\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}