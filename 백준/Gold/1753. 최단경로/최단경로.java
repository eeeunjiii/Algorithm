import java.io.*;
import java.util.*;

public class Main {

    private static int V; // 정점의 개수 1~V번
    private static int E; // 간선의 개수
    private static List<List<Node>> graph=new ArrayList<>();
    private static int[] dist;
    private static StringBuilder sb=new StringBuilder();
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

        Arrays.fill(dist, INF);
        dist[start]=0;

        for(int i=1;i<=V;i++) { 
            int nodeValue=INF;
            int nodeIdx=0;

            for(int j=1;j<=V;j++) {
                if(!visited[j] && dist[j]<nodeValue) {
                    nodeValue=dist[j];
                    nodeIdx=j;
                }
            }
            visited[nodeIdx]=true;

            for(Node next:graph.get(nodeIdx)) {
                if(dist[next.v]>dist[nodeIdx]+next.weight) {
                    dist[next.v]=dist[nodeIdx]+next.weight;
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