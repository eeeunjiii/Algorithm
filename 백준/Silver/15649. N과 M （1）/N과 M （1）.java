import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken()); // 1~n까지의 자연수 중에서
        m=Integer.parseInt(st.nextToken()); // m개를 선택

        visited=new boolean[n];
        arr=new int[m];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth){
        if(depth==m){
            for(int val:arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=i+1;
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }
}