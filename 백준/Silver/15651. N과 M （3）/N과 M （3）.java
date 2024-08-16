import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[M];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth==M) {
            for(int v:arr) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++) {
            arr[depth]=i+1;
            dfs(depth+1);
        }
    }
}