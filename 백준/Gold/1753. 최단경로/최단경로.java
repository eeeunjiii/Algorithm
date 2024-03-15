import java.io.*;
import java.util.*;

public class Main {

    private static int V; // 정점의 개수 1~V번
    private static int E; // 간선의 개수
    private static List<List<Node>> graph=new ArrayList<>();
    private static int[] dist;
    private static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

        dist=new int[V+1];

        for(int i=0;i<=V;i++) {
            graph.add(new ArrayList<>());
        }

        int start=Integer.parseInt(br.readLine());

        for(int i=0;i<E;i++) {
            st=new StringTokenizer(br.readLine());

            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }
        Dijkstra(start);

        for(int i=1;i<=V;i++) {
            if(dist[i]==INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
    private static void Dijkstra(int start) {
        boolean[] visited=new boolean[V+1];

        PriorityQueue<Node> pq=new PriorityQueue<>(
                Comparator.comparing(o -> o.weight)
        );

        Arrays.fill(dist, INF);
        dist[start]=0;

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int index=pq.poll().v;

            if(!visited[index]) visited[index]=true;
            else continue;

            for(Node node:graph.get(index)) {
                if(dist[node.v]>dist[index]+node.weight) {
                    dist[node.v]=dist[index]+node.weight;
                    pq.offer(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
}

class Node {
    int v;
    int weight;

    public Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}