import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        visited=new boolean[N];
        arr=new int[N];

        dfs(0);

        System.out.println(sb);
    }
    private static void dfs(int depth){
        if(depth==N){
            for(int v:arr){
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=i+1;
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }
}