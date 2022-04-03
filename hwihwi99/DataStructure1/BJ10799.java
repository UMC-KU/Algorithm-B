import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 10799 시간 초과 난 방식
 * 모든 (, )의 인덱스를 가지고 계산 시도
 * - ()이렇게 연속해서 나오면 레이져이므로 레이져 값에 double로 중간값을 가지고 계산했다.
 * - ( 이거면 해당 인덱스 번호 저장
 * - ) 이거면 스택에서 pop으로 꺼내면서 pop한거는 start, 현재 번호를 end로 막대기 정보를 저장한다.
 *
 * - 막대기 갯수를 구한 후 레이져 배열을 돌면서 만날때마다 +1을 해주었습니다.
 * 하지만 이 방식은 너무 많은 중첩 for문이 있었고 계산을 해보니 worstcase로 25억번의 연산이 필요했습니다.
 *
 * 그래서 슬쩍 구글링을 해본 결과..
 *
 * ( 일때 스택에 넣고 )일 때 pop하는 건 동일하지만 ()일 경우 레이저이고
 * 스택에 남은 막대기들만 잘리는 것이므로 그 수만큼만 더해주면 되는 것이였다.
 * + 레이져가 아니라 pop으로 막대기를 만들었을 경우에도 +1 을 해줍니다.
 *
 * 이렇게 푼다고 합니다... 정말 또 하나 알아가는 좋은 문제였습니다..
 *
 * */

//class Stick{
//    int start;
//    int end;
//
//    public Stick(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//}
//
//
//public class BJ10799 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        char[] input = str.toCharArray();
//        ArrayList<Double> laser = new ArrayList<>();
//        Stack<Integer> stack = new Stack();
//        ArrayList<Stick> stickArrayList = new ArrayList<>();
//        for(int i = 0; i<input.length; i++) {
//            if(i!=input.length-1 && (input[i] == '(' && input[i+1] == ')')) {
//                double l = (double) (i+i+1)/ 2.0;
//                laser.add(l);
//                i++;
//            } else if (input[i] == '(') {
//                stack.push(i);
//            } else if (input[i] == ')'){
//                Stick stick = new Stick(stack.pop(),i);
//                stickArrayList.add(stick);
//            }
//        }
//        int answer = stickArrayList.size();
//
//        for(Stick s : stickArrayList) {
//            for(Double l : laser) {
//                if(s.start < l && l < s.end) {
//                    answer++;
//                }
//            }
//        }
//        System.out.println(answer);
//
//    }
//}

public class BJ10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] input = str.toCharArray();

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<input.length; i++) {
            if(i!=input.length-1 && (input[i] == '(' && input[i+1] == ')')) {
                answer += stack.size();
                i++;
            } else if (input[i] == '(') {
                stack.push('(');
            } else if (input[i] == ')'){
                stack.pop();
                answer++;
            }
        }
        System.out.println(answer);
    }
}