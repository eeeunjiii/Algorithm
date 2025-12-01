import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] board;
    private static int[][][] dp;
    private static int[] dc={-1, 0, 1}; // 열 이동
    private static int ans=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 행
        M=Integer.parseInt(st.nextToken()); // 열

        board=new int[N][M];
        dp=new int[N][M][3];
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                Arrays.fill(dp[i][j], -1);
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // 같은 방향으로 두 번 연속 움직일 수 없음. -> 이걸 어떻게 하면 좋을까유
        // 좌, 우 대각선 아래, 아래로만 움직일 수 있음
        // 연료를 최대한 적게, 지구 어디서든 출발가능

        for(int i=0;i<M;i++) {
            dfs(0, i, -1, 0);
        }

        System.out.println(ans);
    }

    private static void dfs(int r, int c, int d, int sum) {
        if(r==N) {
            ans=Math.min(ans, sum);
            return;
        }

        for(int i=0;i<3;i++) {
            if(d==i) continue;

            int nc=c+dc[i];
            if(nc>=0 && nc<M) dfs(r+1, nc, i, sum+board[r][c]);
        }
    }
}