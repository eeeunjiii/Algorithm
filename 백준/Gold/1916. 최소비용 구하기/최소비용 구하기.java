import java.io.*;
import java.util.*;

public class Main {

    private static int N; // 도시의 수
    private static int M; // 버스의 수
    private static int start; // 출발 도시
    private static int end; // 도착
    private static ArrayList<ArrayList<Node>> graph=new ArrayList<>(); // 출발, 도착, 비용
    private static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());

        for(int i=0;i<=N;i++) { // 1~N번의 도시
            graph.add(new ArrayList<>());
        }

        for(int j=0;j<M;j++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
        }
        st=new StringTokenizer(br.readLine());

        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());

        int ans = Dijkstra();
        System.out.println(ans);
    }

    private static int Dijkstra() {
        boolean[] visited=new boolean[N+1];
        int[] dist=new int[N+1];

        Arrays.fill(dist, INF);
        dist[start]=0;

        for(int i=1;i<=N;i++) {
            int nodeCost=INF;
            int nodeIdx=0;

            for(int j=1;j<=N;j++) {
                if(!visited[j] && dist[j]<nodeCost) {
                    nodeCost=dist[j];
                    nodeIdx=j;
                }
            }
            visited[nodeIdx]=true;

            for(Node v:graph.get(nodeIdx)) {
                if(dist[v.index]>dist[nodeIdx]+v.cost) {
                    dist[v.index]=dist[nodeIdx]+v.cost;
                }
            }
        }
        return dist[end];
    }
}

class Node {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}