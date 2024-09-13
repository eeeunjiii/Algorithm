import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        board=new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                board[i][j]=Integer.parseInt(st.nextToken()); // 0: 빈칸, 1: 벽 (빈 칸만 이동 가능)
            }
        }
        dfs(1,2,0);
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int dir) { // 0: 가로, 1: 세로, 2: 대각선 (이전 방향)
        if(x==N && y==N) {
            cnt++;
            return;
        }

        if(dir==0) {
            if(y+1<=N && board[x][y+1]==0) dfs(x, y+1, 0);
        } else if(dir==1) {
            if(x+1<=N && board[x+1][y]==0) dfs(x+1, y, 1);
        } else if(dir==2) {
            if(y+1<=N && board[x][y+1]==0) dfs(x, y+1, 0);
            if(x+1<=N && board[x+1][y]==0) dfs(x+1, y, 1);
        }

        if(x+1<=N && y+1<=N && board[x][y+1]==0 && board[x+1][y]==0 && board[x+1][y+1]==0)
            dfs(x+1, y+1, 2);
    }
}