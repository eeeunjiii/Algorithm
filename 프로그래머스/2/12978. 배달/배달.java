import java.util.*;

class Solution {
    
    static List<List<Node>> graph;
    static int[] dist;
    static final int INF=Integer.MAX_VALUE;
    
    public int solution(int N, int[][] road, int K) {
        graph=new ArrayList<>();
        
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<road.length;i++) {
            int start=road[i][0];
            int end=road[i][1];
            int cost=road[i][2];
            
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
        
        Dijkstra(1, N);
        
        int answer=0;
        for(int i=1;i<=N;i++) {
            if(dist[i]<=K) answer++;
        }
        
        return answer;
    }
    
    private void Dijkstra(int start, int N) {
        boolean[] visited=new boolean[N+1];
        dist=new int[N+1];
        
        PriorityQueue<Node> queue=new PriorityQueue<>(
            Comparator.comparing(o -> o.cost)
        );
        
        Arrays.fill(dist, INF);
        dist[start]=0;
        
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
    
    public class Node {
        private int v;
        private int cost;
        
        public Node(int v, int cost) {
            this.v=v;
            this.cost=cost;
        }
    }
}