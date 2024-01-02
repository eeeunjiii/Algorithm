import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[][] W;
    private static boolean[] visited;
    private static int minCost=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());

        W=new int[N+1][N+1];
        visited=new boolean[N+1];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                W[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        visited[0]=true; // 0부터 시작하기 때문에 true로 처리

        dfs(0, 0,0);

        System.out.println(minCost);
    }
    private static void dfs(int depth, int check, int cost){ // 시작지점을 0으로 설정
        if(depth==N-1){
            if(W[check][0]!=0){
                minCost=Math.min(minCost, cost+W[check][0]); // 다 돌았으면 시작점으로 이동
            }
            return ;
        }
        for(int i=0;i<N;i++){
            if(!visited[i] && W[check][i]!=0){
                visited[i]=true;
                dfs(depth+1, i, cost+W[check][i]);
                visited[i]=false;
            }
        }
    }
}