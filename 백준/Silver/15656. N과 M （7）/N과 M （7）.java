import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] ans;
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N];
        ans=new int[M];

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
            for(int val:ans) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++) {
            ans[depth]=arr[i];
            dfs(depth+1);
        }
    }
}