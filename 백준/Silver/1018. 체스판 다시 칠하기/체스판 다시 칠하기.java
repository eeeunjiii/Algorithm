import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M=Integer.parseInt(st.nextToken()); // 행
        int N=Integer.parseInt(st.nextToken()); // 열

        char[][] board=new char[M][N];

        for(int i=0;i<M;i++) {
            String line=br.readLine();

            for(int j=0;j<N;j++) {
                board[i][j]=line.charAt(j);
            }
        }

        int min = getMin(M, N, board);

        System.out.println(min);
    }

    private static int getMin(int M, int N, char[][] board) {
        int min=Integer.MAX_VALUE;

        for(int i = 0; i<= M -8; i++) {
            for(int j = 0; j<= N -8; j++) {
                for(int k=0;k<2;k++) {
                    char start = k==0 ? 'W':'B'; // 처음에 탐색 기준을 잡는다.

                    int cnt=0;

                    for(int m=i;m<i+8;m++) {
                        for(int n=j;n<j+8;n++) {
                            if(start != board[m][n]) {
                                cnt++;
                            }
                            start=start=='W'?'B':'W'; // 한 칸씩 이동하면서 W, B가 바뀌어야 하기 때문
                        }
                        start=start=='W'?'B':'W';
                    }
                    min=Math.min(min, cnt);
                }
            }
        }
        return min;
    }
}