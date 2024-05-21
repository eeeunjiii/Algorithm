import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dx={-1,1,0,0};
    private static final int[] dy={0,0,-1,1};
    private static int N; // 세로 (행)
    private static int M; // 가로 (열)
    private static int[][] cheese;
    private static boolean[][] visited;
    private static int cheeseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        cheese=new int[N][M];

        cheeseCnt=0;
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                cheese[i][j]=Integer.parseInt(st.nextToken()); // 0: 공기, 1: 치즈
                if(cheese[i][j]==1) cheeseCnt++;
            }
        }

        // 1. 상하좌우를 탐색하면서 0과 맞닿아 있다면 없어짐.
        // 2. 치즈의 구멍은 0이어도 공기가 없기 때문에 그 주변은 없어지지 않음. -> 이 부분을 어떻게 처리해야 할지
        // 맞닿아 있는 0의 개수로는 판단할 수 없음 (경계와 구멍을 어떻게 구분할지)
        // 3. 모두 없어지는 데에 얼마나 걸리는지 계산 (기존 문제들처럼 하면 될 듯)
        // 4. 모두 녹기 전 한 시간 전에 남아 있는 칸의 수 -> 이 부분을 어떻게 처리해야 할지

        int cnt=0;
        int time=0;

        while(cheeseCnt!=0) {
            cnt=cheeseCnt;
            time++;
            visited=new boolean[N][M];
            bfs();
        }
        System.out.println(time);
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0]=true;

        while(!queue.isEmpty()) {
            int[] v=queue.poll();

            for(int i=0;i<4;i++) {
                int nx=v[0]+dx[i];
                int ny=v[1]+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

                if(!visited[nx][ny]) {
                    visited[nx][ny]=true;
                    if(cheese[nx][ny]==0) {
                        queue.offer(new int[] {nx, ny});
                    } else {
                        cheeseCnt--;
                        cheese[nx][ny]=0;
                    }
                }
            }
        }
    }
}
