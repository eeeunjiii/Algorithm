import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] ans;
    private static boolean[] visited;
    private static int max=Integer.MIN_VALUE;
    private static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        ans=new int[N];
        visited=new boolean[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int depth) {
        if(depth==N) {
            int sum=0;
            for(int i=0;i<N-1;i++){
                sum+=Math.abs(ans[i]-ans[i+1]);
            }
            max=Math.max(sum, max);
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