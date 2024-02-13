import java.io.*;
import java.util.*;

public class Main {
    private static int N; // 세로 (행)
    private static int M; // 가로 (열)
    private static int K; // 쓰레기 개수
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx={-1,1,0,0};
    private static final int[] dy={0,0,-1,1};
    private static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        map=new int[N+1][M+1];
        visited=new boolean[N+1][M+1];

        for(int i=0;i<K;i++) {
            st=new StringTokenizer(br.readLine());

            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());

            map[num1][num2]=1;
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if(!visited[i][j] && map[i][j]==1) {
                    visited=new boolean[N+1][M+1];
                    max=Math.max(max, bfs(i, j));
                }
            }
        }
        System.out.println(max);
    }
    private static int bfs(int x, int y) {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y]=true;

        int cnt=map[x][y];

        while(!queue.isEmpty()) {
            int[] v=queue.poll();

            for(int i=0;i<4;i++) {
                int nx=v[0]+dx[i];
                int ny=v[1]+dy[i];

                if(nx<0 || ny<0 || nx>=N+1 || ny>=M+1) continue;
                if(!visited[nx][ny] && map[nx][ny]==1) {
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx, ny});
                    cnt+=map[nx][ny];
                }
            }
        }
        return cnt;
    }
}