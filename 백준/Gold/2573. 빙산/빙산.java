import java.io.*;
import java.util.*;
public class Main {
    private static int N; // 행
    private static int M; // 열
    private static int[][] map;
    private static int[] dr={-1,1,0,0}; // 행
    private static int[] dc={0,0,-1,1}; // 열

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 행
        M=Integer.parseInt(st.nextToken()); // 열

        map=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int result=0; // 걸리는 시간 (년)
        int cnt=0; // 빙하의 개수

        while((cnt=countIce())<2){
            if(cnt==0) {
                result=0;
                break;
            }
            bfs();
            result++;
        }
        System.out.println(result);
    }

    private static int countIce(){ // 빙하의 개수를 세는 함수 (dfs 사용)
        int iceCnt=0;

        boolean[][] visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!=0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    iceCnt++;
                }
            }
        }
        return iceCnt;
    }
    private static void dfs(int i, int j, boolean[][] visited){
        visited[i][j]=true;

        for(int l=0;l<4;l++){
            int nr=i+dr[l];
            int nc=j+dc[l];

            if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
            if(map[nr][nc]!=0 && !visited[nr][nc]) dfs(nr, nc, visited);
        }
    }

    private static void bfs(){ // 빙하를 녹이는 함수
        Queue<int[]> queue=new LinkedList<>();

        boolean[][] visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!=0){
                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }

        while(!queue.isEmpty()){
            int seaCnt=0; // 바다의 개수

            int[] v=queue.poll();

            for(int i=0;i<4;i++){
                int nr=v[0]+dr[i];
                int nc=v[1]+dc[i];

                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                if(map[nr][nc]==0 && !visited[nr][nc]) {
                    seaCnt++;
                }
            }
            if(map[v[0]][v[1]]-seaCnt<0) map[v[0]][v[1]]=0;
            else map[v[0]][v[1]]-=seaCnt;
        }
    }
}