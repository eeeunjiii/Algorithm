import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dx={-1,1,0,0};
    private static int[] dy={0,0,-1,1};
    private static int ans=0;
    private static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        board=new int[N+1][N+1];
        visited=new boolean[N+1][N+1];

        StringTokenizer st;
        for(int i=1;i<=N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(!visited[i][j]) dfs(i, j, 0);
            }
        }

        System.out.println(min);
    }

    private static void dfs(int x, int y, int depth) {
        if(depth==3) {
            min=Math.min(ans, min);
            return;
        }

        if(check(x, y)) {
            makeTrue(x, y);

            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(!visited[i][j]) dfs(i, j, depth+1);
                }
            }

            makeFalse(x, y);
        }
    }

    private static boolean check(int x, int y) {
        if(visited[x][y]) return false;

        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<=0 || ny<=0 || nx>=N+1 || ny>=N+1) return false;
            if(visited[nx][ny]) return false;
        }
        return true;
    }

    private static void makeTrue(int x, int y) {
        visited[x][y]=true;
        ans+=board[x][y];

        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            visited[nx][ny]=true;
            ans+=board[nx][ny];
        }
    }

    private static void makeFalse(int x, int y) {
        visited[x][y]=false;
        ans-=board[x][y];

        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            visited[nx][ny]=false;
            ans-=board[nx][ny];
        }
    }
}