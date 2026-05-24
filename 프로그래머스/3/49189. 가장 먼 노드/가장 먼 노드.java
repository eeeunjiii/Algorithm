import java.util.*;

class Solution {
    
    static int[] dist;
    static List<List<Integer>> list;
    static int level=1;
    static int max=Integer.MIN_VALUE;
    
    public int solution(int n, int[][] edge) {
        // 1번 노드에서 가장 멀리 떨어진 노드의 개수
        list=new ArrayList<>();
        for (int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i=0;i<edge.length;i++) {
            for (int j=0;j<2;j++) {
                int a=edge[i][0];
                int b=edge[i][1];
                
                list.get(a).add(b);
                list.get(b).add(a);
            }
        }
        
        dist=new int[n+1];
        dist[1]=0;
        
        bfs(n);
        
        int ans=0;
        for (int i=1;i<=n;i++) {
            if (dist[i]==max) {
                ans++;
            }
        }
        
        return ans;
    }
    
    static void bfs(int n) {
        // start==1;
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[n+1];
        
        queue.offer(1);
        visited[1]=true;
        
        while (!queue.isEmpty()) {
            int cur=queue.poll();
            
            for (int next:list.get(cur)) {
                if (!visited[next]) {
                    visited[next]=true;
                    dist[next]=dist[cur]+1;
                    queue.offer(next);
                    
                    max=Math.max(max, dist[next]);
                }
            }
        }
    }
}