import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean[][] visited;
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new char[N][M];
        visited=new boolean[N][M];

        int x=0;
        int y=0;
        for(int i=0;i<N;i++) {
            String line=br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j]=line.charAt(j);
                if(map[i][j]=='I') {
                    x=i;
                    y=j;
                }
            }
        }
        dfs(x, y);

        if(cnt!=0) System.out.println(cnt);
        else System.out.println("TT");
    }

    static void dfs(int x, int y) {
        visited[x][y]=true;

        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=M || 
                    visited[nx][ny] || map[nx][ny]=='X') continue;
            else {
                if(map[nx][ny]=='P') cnt++;
                dfs(nx, ny);
            }
        }
    }
}