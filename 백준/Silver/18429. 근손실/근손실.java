import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] weight;
    static boolean[] visited;
    static int ans=0;
    static int total=500;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        weight=new int[N];
        visited=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            weight[i]=Integer.parseInt(st.nextToken());
        }

        DFS(0);
        System.out.println(ans);
    }

    static void DFS(int depth) {
        if (depth==N) {
            ans++;
            return;
        }

        for (int i=0;i<N;i++) {
            if (!visited[i] && total-K+weight[i]>=500) {
                visited[i]=true;
                total=total-K+weight[i];
                DFS(depth+1);
                visited[i]=false;
                total=total+K-weight[i];
            }
        }
    }
}