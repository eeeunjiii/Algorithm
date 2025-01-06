import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static List<Integer> prev[];
    private static int[] arr, dp, vertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N+1];
        dp=new int[N+1];
        vertex=new int[N+1];

        prev=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            prev[i]=new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1;i<=N;i++) {
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()) {
                int build=Integer.parseInt(st.nextToken());
                if(build==-1) break;
                prev[build].add(i);
                vertex[i]++;
            }
        }
        topologySort();
        for(int i=1;i<=N;i++) {
            System.out.println(dp[i]);
        }
    }

    private static void topologySort() {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=N;i++) {
            if(vertex[i]==0) { // 필요한 선행 건물이 없을 경우
                queue.offer(i);
                dp[i]=arr[i];
            }
        }

        while(!queue.isEmpty()) {
            int v=queue.poll();

            for(int next:prev[v]) {
                dp[next]=Math.max(dp[next], dp[v]+arr[next]);
                vertex[next]--;
                if(vertex[next]==0) queue.offer(next);
            }
        }
    }
}