//22.05.09
/*
하루에 한 시간 단위로 일을 하거나 일을 쉬어도 된다. 하루에 한 시간 일하면 피로도는 A만큼 쌓이고 일은 B만큼 처리할 수 있다.
만약에 한 시간을 쉰다면 피로도는 C만큼 줄어든다. 단, 피로도가 음수로 내려가면 0으로 바뀐다. 당연히 일을 하지 않고 쉬었기 때문에 처리한 일은 없다.
피로도를 최대한 M을 넘지 않게 일을 하려고 한다. M를 넘기면 일하는데 번아웃이 와서 이미 했던 일들도 다 던져버리고 일을 그만두게 된다.
번아웃이 되지 않도록 일을 할때 하루에 최대 얼마나 일을 할 수 있는지 구해보자. 하루는 24시간이다.
 */

package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);
        int m = Integer.parseInt(inputs[3]);

        int piro=0;
        int work=0;
        for (int i=0; i<24; i++) {
            if (piro+a > m) {
                piro -= c;
                if (piro<0) {
                    piro=0;
                }
            } else {
                piro += a;
                work += b;
            }
        }
        System.out.println(work);
    }
}
