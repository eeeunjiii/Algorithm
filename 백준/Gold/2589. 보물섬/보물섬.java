import java.io.*;
import java.util.*;

public class Main {
    private static int N; // 행
    private static int M; // 열
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dr ={0,0,-1,1};
    private static final int[] dc ={-1,1,0,0};
    private static int maxValue =Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];

        for(int i=0;i<N;i++){
            String line=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=line.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='L'){
                    visited=new boolean[N][M];
                    int val=bfs(i, j);
                    maxValue = Math.max(maxValue,val);
                }
            }
        }
        System.out.println(maxValue);
    }

    private static int bfs(int x, int y){
        Queue<Node> queue=new LinkedList<>();
        int cnt=0;

        visited[x][y]=true;
        queue.add(new Node(x, y, 0));

        while(!queue.isEmpty()){
            Node v=queue.poll();

            for(int l=0;l<4;l++){
                int nr=v.r+dr[l];
                int nc=v.c+dc[l];

                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                if(!visited[nr][nc] && map[nr][nc]=='L'){
                    queue.add(new Node(nr, nc, v.dist+1));
                    visited[nr][nc] = true;
                    cnt=Math.max(cnt, v.dist+1);
                }
            }
        }
        return cnt;
    }

    public static class Node{
        int r;
        int c;
        int dist;

        public Node(int r, int c, int dist){
            this.r =r;
            this.c =c;
            this.dist=dist;
        }
    }
}