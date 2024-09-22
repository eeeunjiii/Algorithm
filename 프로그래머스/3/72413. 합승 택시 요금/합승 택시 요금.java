import java.util.*;

class Solution {
    
    static final int MAX=Integer.MAX_VALUE;
    static List<List<Node>> graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph=new ArrayList<>(n+1);
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare:fares) {
            int start=fare[0];
            int end=fare[1];
            int cost=fare[2];
            
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
        
        int[] startA=dijkstra(a, n);
        int[] startB=dijkstra(b, n);
        int[] start=dijkstra(s, n);
        
        int answer=MAX;
        for(int i=1;i<=n;i++) {
            answer=Math.min(answer, startA[i]+startB[i]+start[i]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int[] dist=new int[n+1];
        Arrays.fill(dist, MAX);
        
        dist[start]=0;
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            int now=pq.poll().end;
            
            for(Node next:graph.get(now)) {
                if(dist[next.end]>dist[now]+next.cost) {
                    dist[next.end]=dist[now]+next.cost;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
        
        return dist;
    }
    
    class Node implements Comparable<Node> {
        int end;
        int cost;
        
        public Node(int end, int cost) {
            this.end=end;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(Node e) {
            return this.cost-e.cost;
        }
    }
}