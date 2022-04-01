//22.04.02
/*
이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다.
우선, 제일 위에 있는 카드를 바닥에 버린다.
그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다.
1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다.
3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다.
마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
 */
//n이 짝수일때까진 홀수번쨰 숫자들 다 버려짐
package data_structure;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int index=1;
        while (n%2==0){
            index*=2;
            n/=2;
        }

        ArrayList<Integer> queue = new ArrayList<>();
        int front=0, back=n;
        for (int i=0; i<n; i++){
            queue.add(i, (i+1)*index);
        }
        while (back-front >1) {
            front++;

            if (back-front==1){
                break;
            }
            queue.add(back, queue.get(front));
            front++;
            back++;
        }
        System.out.println(queue.get(front));
    }
}
