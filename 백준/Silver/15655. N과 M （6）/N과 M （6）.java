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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        bfs(0, 0);

        System.out.println(sb);
    }
    private static void bfs(int depth, int start) {
        if(depth==M) { // M개를 선택했을 시
            for(int v:ans) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<N;i++) {
            if(!visited[i]) {
                visited[i]=true;
                ans[depth]=arr[i]; // ans에 대입할 때에는 depth로 인덱스 설정
                bfs(depth+1, i);
                visited[i]=false;
            }
        }
    }
}