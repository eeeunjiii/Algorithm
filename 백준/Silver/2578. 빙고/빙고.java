import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board=new int[5][5];
        for (int i=0;i<5;i++) {
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<5;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int ans=0;

        for (int i=0;i<5;i++) {
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<5;j++) {
                int num=Integer.parseInt(st.nextToken()); // 부른 숫자

                for (int l=0;l<5;l++) {
                    for (int k=0;k<5;k++) {
                        if (board[l][k]==num) {
                            board[l][k]=-1; // 지운 빙고 칸 표시
                            ans++;
                        }
                    }
                }
                rCheck();
                cCheck();
                lrCheck();
                rlCheck();

                if (cnt>=3) {
                    System.out.println(ans);
                    return;
                }
                cnt=0;
            }
        }
    }

    private static void rCheck() {
        for (int i=0;i<5;i++) {
            int zeroCnt=0;
            for (int j=0;j<5;j++) {
                if (board[i][j]==-1) zeroCnt++;
            }
            if (zeroCnt==5) cnt++;
        }
    }

    private static void cCheck() {
        for (int i=0;i<5;i++) {
            int zeroCnt=0;
            for (int j=0;j<5;j++) {
                if (board[j][i]==-1) zeroCnt++;
            }
            if (zeroCnt==5) cnt++;
        }
    }

    private static void lrCheck() {
        int zeroCnt=0;
        for (int i=0;i<5;i++) {
            if (board[i][i]==-1) zeroCnt++;
        }
        if (zeroCnt==5) cnt++;
    }

    private static void rlCheck() {
        int zeroCnt=0;
        for (int i=4;i>=0;i--) {
            if (board[4-i][i]==-1) zeroCnt++;
        }
        if (zeroCnt==5) cnt++;
    }
}