import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        ans=new int[M];
        visited=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        backtracking(0);

        System.out.println(sb);
    }

    static void backtracking(int depth) {
        if(depth==M) {
            for(int val:ans) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before=-1;
        for(int i=0;i<N;i++) {
            int now=arr[i];

            if(now!=before) {
                before=now;
                ans[depth]=arr[i];
                backtracking(depth+1);
            }
        }
    }
}