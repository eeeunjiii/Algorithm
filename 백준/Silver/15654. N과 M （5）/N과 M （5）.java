import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] arr;
    private static int[] ans;
    private static boolean[] visited;
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        ans=new int[M];
        arr=new int[N];
        visited=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth==M) {
            for(int v:ans) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i]=true;
                ans[depth]=arr[i];
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }
}