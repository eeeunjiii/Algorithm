import java.util.*;

class Solution {
    
    static List<List<Integer>> graph;
    static int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph=new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<roads.length;i++) {
            int a=roads[i][0];
            int b=roads[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dist=new int[n+1];
        Arrays.fill(dist, -1);
        
        bfs(destination);
        
        int[] answer=new int[sources.length];
        for(int i=0;i<sources.length;i++) {
            answer[i]=dist[sources[i]];
        }
        
        return answer;
    }
    
    static void bfs(int start) {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(start);
        dist[start]=0;
        
        while(!queue.isEmpty()) {
            int v=queue.poll();
            
            for(int now:graph.get(v)) {
                if(dist[now]==-1) {
                    dist[now]=dist[v]+1;
                    queue.offer(now);
                }
            }
        }
    }
}