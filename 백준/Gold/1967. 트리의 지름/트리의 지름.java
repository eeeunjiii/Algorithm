import java.io.*;
import java.util.*;

public class Main {
    private static int N; // 노드의 개수
    private static ArrayList<Integer[]>[] map; // 부모, 자식, 가중치
    private static boolean[] visited;
    private static int ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        map=new ArrayList[N+1];
        visited=new boolean[N+1];

        for(int i=1;i<map.length;i++){
            map[i]=new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            int child=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());

            map[parent].add(new Integer[]{child, value});
            map[child].add(new Integer[]{parent, value});
        }

        for(int i=1;i<=N;i++){
            Arrays.fill(visited, false); // 모든 노드에서 시작하기 때문에 한 노드에서의 탐색이 끝나면 초기화
            dfs(i, 0);
        }
        System.out.println(ans);
    }
    private static void dfs(int start, int sum){
        visited[start]=true;
        ans=Math.max(ans, sum);

        for(Integer[] val:map[start]){
            int child=val[0];
            int value=val[1];

            if(!visited[child]){
                dfs(child, sum+value);
            }
        }
    }
}