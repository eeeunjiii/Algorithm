import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] graph;
    private static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        graph=new int[N][N];
        ans=new int[3]; // -1 0 1

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
//        System.out.println(Arrays.toString(ans));
        for(int i=0;i<3;i++) {
            System.out.println(ans[i]);
        }
    }

    private static void divide(int x, int y, int size) {
        if(check(x, y, graph[x][y], size)) {
            if(graph[x][y]==-1) ans[0]++;
            else if(graph[x][y]==0) ans[1]++;
            else if(graph[x][y]==1) ans[2]++;
            return;
        }

        divide(x, y, size/3);
        divide(x, y+size/3, size/3);
        divide(x+size/3, y, size/3);
        divide(x+2*(size/3), y, size/3);
        divide(x, y+2*(size/3), size/3);
        divide(x+size/3, y+size/3, size/3);
        divide(x+size/3, y+2*(size/3), size/3);
        divide(x+2*(size/3), y+size/3, size/3);
        divide(x+2*(size/3), y+2*(size/3), size/3);
    }

    private static boolean check(int x, int y, int value, int size) {
        for(int i=x;i<x+size;i++) {
            for(int j=y;j<y+size;j++) {
                if(graph[i][j]!=value) return false;
            }
        }
        return true; // 모두 동일한 값을 가진 경우
    }
}