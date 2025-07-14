import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> graph=new ArrayList<>();
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine()); // 노드의 개수

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        parent=new int[N+1];
        visited=new boolean[N+1];

        for(int i=0;i<N-1;i++) {
            st=new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a); // 양방향으로 저장
        }

        // 트리의 루트를 1이라고 가정했을 때, 각 노드의 부모를 구하기
        // 트리 상에서 연결된 두 정점이 주어짐
        // 각 노드의 부모 노드 번호를 출력
        dfs(1);

        for(int i=2;i<=N;i++) {
            System.out.println(parent[i]);
        }

    }

    static void dfs(int start) {
        visited[start]=true;

        for(int node:graph.get(start)) {
            if(!visited[node]) {
                parent[node]=start;
                dfs(node);
            }
        }
    }
}