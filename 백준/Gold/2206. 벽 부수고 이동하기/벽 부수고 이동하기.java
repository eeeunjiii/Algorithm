import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        dist=new int[N][M];

        for(int i=0;i<N;i++) {
            String line=br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j]=line.charAt(j)-'0';
            }
        }
        bfs();
    }

    static void bfs() {
        boolean[][][] visited=new boolean[N][M][2];
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[] {0,0,0}); // x, y, w (벽을 부순 여부)

        while(!queue.isEmpty()) {
            int[] v=queue.poll();
            int x=v[0];
            int y=v[1];
            int w=v[2];
            
            if(x==N-1 && y==M-1) {
                System.out.println(dist[x][y]+1);
                return;
            }

            for(int i=0;i<4;i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(map[nx][ny]==0) { // 벽이 아닌 경우
                    if(!visited[nx][ny][w]) {
                        visited[nx][ny][w]=true;
                        dist[nx][ny]=dist[x][y]+1;
                        queue.offer(new int[] {nx, ny, w});
                    }
                } else { // 벽인 경우
                    if(w==0 && !visited[nx][ny][1]) { // 한 번도 벽을 부수지 않은 경우
                        visited[nx][ny][1]=true;
                        dist[nx][ny]=dist[x][y]+1;
                        queue.offer(new int[] {nx, ny, 1});
                    }
                }

                if(nx==N-1 && ny==M-1) {
                    System.out.println(dist[nx][ny]+1); // 도착지점 포함
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}