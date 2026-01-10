import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new char[N][M];

        for (int i=0;i<N;i++) {
            String line=br.readLine();
            for (int j=0;j<M;j++) {
                board[i][j]=line.charAt(j);
            }
        }

        // 직사각형 모양의 성의 모든 행과 모든 열에 한 명 이상의 경비원 있어야 함.
        // 몇 명의 경비원을 최소로 추가해야 하는지
        // .: 빈칸, X: 경비원

        // 행의 모든 부분이 비워져 있는 개수와 열의 모든 부분이 비워져 있는 개수 중 더 큰 것
        int ans=Math.max(countEmptyCol(), countEmptyRow());
        System.out.println(ans);
    }

    static int countEmptyRow() {
        int rowCnt=0;

        for (int i=0;i<N;i++) {
            int dotCnt=0;
            for (int j=0;j<M;j++) {
                if (board[i][j]=='.') dotCnt++;
            }
            if (dotCnt==M) rowCnt++;
        }
        return rowCnt;
    }

    static int countEmptyCol() {
        int colCnt=0;

        for (int i=0;i<M;i++) {
            int dotCnt=0;
            for (int j=0;j<N;j++) {
                if (board[j][i]=='.') dotCnt++;
            }
            if (dotCnt==N) colCnt++;
        }
        return colCnt;
    }
}