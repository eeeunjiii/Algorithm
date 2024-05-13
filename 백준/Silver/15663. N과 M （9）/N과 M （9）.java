import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static boolean[] visited;
    private static int[] ans;
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N];
        visited=new boolean[N];
        ans=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb);
    }
    private static void dfs(int depth) { // 중복되는 수열 출력되면 안 됨
        if(depth==M) {
            for(int v:ans) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before=0; // 이전의 값 저장한 후 비교
        for(int i=0;i<N;i++) {
            if(!visited[i] && before!=arr[i]) {
                visited[i]=true;
                ans[depth]=arr[i];
                before=arr[i];
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }
}
