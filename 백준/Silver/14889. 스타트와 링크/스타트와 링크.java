import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] graph;
    private static boolean[] visited;
    private static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        graph=new int[N][N];
        visited=new boolean[N];

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(min);
    }
    
    private static void calSum() {
        int sumStart=0;
        int sumLink=0;
        
        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                if(visited[i] && visited[j]) {
                    sumStart+=graph[i][j]+graph[j][i];
                } else if(!visited[i] && !visited[j]) {
                    sumLink+=graph[i][j]+graph[j][i];
                }
            }
        }
        int diff=Math.abs(sumStart-sumLink);
        
        if(diff==0) {
            System.out.println(diff);
            System.exit(0);
        }
        min=Math.min(min, diff);
    }
    
    private static void dfs(int depth, int start) {
        if(depth==N/2) {
            calSum();
            return;
        }
        for(int i=start;i<N;i++) {
            if(!visited[i]) {
                visited[i]=true;
                dfs(depth+1, i+1);
                visited[i]=false;
            }
        }
    }
}