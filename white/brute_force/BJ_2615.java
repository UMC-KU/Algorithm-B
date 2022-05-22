//22.05.22
/*
입력으로 바둑판의 어떤 상태가 주어졌을 때, 검은색이 이겼는지, 흰색이 이겼는지 또는 아직 승부가 결정되지 않았는지를 판단하는 프로그램을 작성하시오.
단, 검은색과 흰색이 동시에 이기거나 검은색 또는 흰색이 두 군데 이상에서 동시에 이기는 경우는 입력으로 들어오지 않는다.

19줄에 각 줄마다 19개의 숫자로 표현되는데, 검은 바둑알은 1, 흰 바둑알은 2, 알이 놓이지 않는 자리는 0으로 표시되며,
숫자는 한 칸씩 띄어서 표시된다.

첫줄에 검은색이 이겼을 경우에는 1을, 흰색이 이겼을 경우에는 2를, 아직 승부가 결정되지 않았을 경우에는 0을 출력한다.
검은색 또는 흰색이 이겼을 경우에는 둘째 줄에 연속된 다섯 개의 바둑알 중에서 가장 왼쪽에 있는 바둑알(연속된 다섯 개의 바둑알이 세로로 놓인 경우,
그 중 가장 위에 있는 것)의 가로줄 번호와, 세로줄 번호를 순서대로 출력한다.
 */

package brute_force;

import java.io.*;

public class BJ_2615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] board = new String[29][29];
        for (int i=5; i<24; i++) {
            board[i] = ("0 0 0 0 0 "+br.readLine()+" 0 0 0 0 0").split(" ");
        }

        boolean flag = false;
        String resultWin = "0";
        int i=0, j=0;
        for (i=5; i<24; i++) {
            for (j=5; j<24; j++) {
                if (!board[i][j].equals("0")) {
                    String s = board[i][j];
                    if (s.equals(board[i+1][j]) && s.equals(board[i+2][j]) && s.equals(board[i+3][j]) && s.equals(board[i+4][j])){
                        if (!s.equals(board[i-1][j]) && !s.equals(board[i+5][j])) {
                            flag= true;
                            resultWin = s;
                            break;
                        }
                    }
                    if (s.equals(board[i][j+1]) && s.equals(board[i][j+2]) && s.equals(board[i][j+3]) && s.equals(board[i][j+4])){
                        if (!s.equals(board[i][j-1]) && !s.equals(board[i][j+5])) {
                            flag= true;
                            resultWin = s;
                            break;
                        }
                    }
                    if (s.equals(board[i+1][j+1]) && s.equals(board[i+2][j+2]) && s.equals(board[i+3][j+3]) && s.equals(board[i+4][j+4])){
                        if (!s.equals(board[i-1][j-1]) && !s.equals(board[i+5][j+5])) {
                            flag= true;
                            resultWin = s;
                            break;
                        }
                    }
                    if (s.equals(board[i-1][j+1]) && s.equals(board[i-2][j+2]) && s.equals(board[i-3][j+3]) && s.equals(board[i-4][j+4])){
                        if (!s.equals(board[i+1][j-1]) && !s.equals(board[i-5][j+5])) {
                            flag= true;
                            resultWin = s;
                            break;
                        }
                    }
                }
            }
            if (flag) break;
        }

        bw.write(resultWin+"\n");
        if (!resultWin.equals("0")) {
            bw.write((i-4)+" "+(j-4));
        }
        bw.flush();
        bw.close();
    }
}
