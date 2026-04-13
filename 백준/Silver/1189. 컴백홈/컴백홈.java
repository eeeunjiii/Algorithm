import java.io.*;
import java.util.*;

public class Main {

    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        map=new char[R][C];
        visited=new boolean[R][C];

        // 집까지 도착하는 경우가 거리가 K인 가짓수
        for (int i=0;i<R;i++) {
            String line=br.readLine();
            for (int j=0;j<C;j++) {
                map[i][j]=line.charAt(j);
            }
        }

        visited[R-1][0]=true;
        dfs(1, R-1, 0);

        System.out.println(count);
    }

    static void dfs(int depth, int x, int y) {
        if (depth==K && x==0 && y==C-1) {
            count++;
            return;
        }

        for (int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (nx<0 || ny<0 || nx>=R || ny>=C) continue;
            if (!visited[nx][ny] && map[nx][ny]=='.') {
                visited[nx][ny]=true;
                dfs(depth+1, nx, ny);
                visited[nx][ny]=false;
            }
        }
    }
}