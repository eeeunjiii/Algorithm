import java.io.*;
import java.util.*;

public class Main {

    static int[] dist;
    static List<List<Node>> graph=new ArrayList<>();
    static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 노드 개수
        int M=Integer.parseInt(st.nextToken()); // 간선 개수

        dist=new int[N+1];

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        Dijkstra(1, N);

        System.out.println(dist[N]);
    }

    private static void Dijkstra(int start, int N) {
        boolean[] visited=new boolean[N+1];

        Arrays.fill(dist, INF);
        dist[start]=0;

        PriorityQueue<Node> queue=new PriorityQueue<>(Comparator.comparing(o->o.cost));
        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()) {
            int idx=queue.poll().v;

            if(!visited[idx]) visited[idx]=true;
            else continue;

            for(Node next:graph.get(idx)) {
                if(dist[next.v]>dist[idx]+next.cost) {
                    dist[next.v]=dist[idx]+next.cost;
                    queue.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    static public class Node {
        private int v;
        private int cost;

        public Node(int v, int cost) {
            this.v=v;
            this.cost=cost;
        }
    }
}