import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N; // 세로 격자 수 (행)
    private static int M; // 가로 격자 수 (열)
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx={-1,1,0,0};
    private static final int[] dy={0,0,-1,1};
    private static int cnt=0; // 치즈가 있는 부분의 개수
    private static ArrayList<Cheese> cheeseList=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());

                if(map[i][j]==1) {
                    cheeseList.add(new Cheese(i, j)); // 1인 부분만 미리 list에 담아두기
                    cnt++;
                }
            }
        }

        int ans=0;

        while(cnt!=0) {
            visited=new boolean[N][M]; // 모두 사라질 때까지 새로 탐색을 하기 때문에 초기화 필요
            countEmpty();
            bfs();
            ans++;
        }
        System.out.println(ans);

    }
    private static void countEmpty() { // bfs로 외부 공기인지 판별
        Queue<Cheese> queue=new LinkedList<>();
        queue.offer(new Cheese(0,0));
        visited[0][0]=true;
        map[0][0]=2; // 가장자리에는 치즈가 놓이지 않음 -> 외부 공기

        while(!queue.isEmpty()) {
            Cheese cheese=queue.poll();

            for(int i=0;i<4;i++) {
                int nx=cheese.x+dx[i];
                int ny=cheese.y+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(visited[nx][ny] || map[nx][ny]==1) continue;

                map[nx][ny]=2; // 외부 공기는 2로 표시
                queue.offer(new Cheese(nx, ny));
                visited[nx][ny]=true;
            }
        }
    }

    private static void bfs() {
        for(int i=0;i<cheeseList.size();i++) {
            int temp=0;
            int x=cheeseList.get(i).x;
            int y=cheeseList.get(i).y;

            for(int j=0;j<4;j++) {
                int nx=x+dx[j];
                int ny=y+dy[j];

                // 가장자리에는 치즈가 놓이지 않기 때문에 구간 확인할 필요가 없다.

                if(map[nx][ny]==2) temp++;
            }
            if(temp>=2) {
                map[x][y]=0; // 해당 부분이 녹았을 경우 0으로 표시
                cnt--;
                cheeseList.remove(i); // 하나를 지우면서 앞으로 앞당겨지기 때문에
                i--; // i를 하나씩 빼준다.
            }
        }
    }

    private static class Cheese {
        int x;
        int y;

        public Cheese(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}