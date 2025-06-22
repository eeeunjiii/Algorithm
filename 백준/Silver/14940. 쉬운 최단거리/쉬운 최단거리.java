import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int startX, startY;
    static int[][] board;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx={0, 0, -1, 1};
    static int[] dy={-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new int[N][M];
        visited =new boolean[N][M];
        dist=new int[N][M];

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
                if(board[i][j]==2) {
                    startX=i;
                    startY=j;
                }
            }
        }

        bfs(startX, startY);

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(board[i][j]==0 || board[i][j]==2) {
                    sb.append("0").append(" ");
                } else if(!visited[i][j] && board[i][j]==1) {
                    sb.append("-1").append(" ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j]=true;

        while(!queue.isEmpty()) {
            int[] v=queue.poll();
            int x=v[0];
            int y=v[1];

            for(int d=0;d<4;d++) {
                int nx=x+dx[d];
                int ny=y+dy[d];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(!visited[nx][ny] && board[nx][ny]==1) {
                    visited[nx][ny]=true;
                    queue.offer(new int[] {nx, ny});
                    dist[nx][ny]=dist[x][y]+1;
                }
            }
        }
    }
}