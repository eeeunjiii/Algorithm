import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        List<List<Integer>> list=new ArrayList<>();
        
        for (int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (i==j) continue;
                if (computers[i][j]==1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        
        boolean[] visited=new boolean[n];
        int ans=0;
        
        for (int i=0;i<n;i++) {
            Queue<Integer> queue=new LinkedList<>();
            queue.offer(i);
            
            if (visited[i]) continue;
            
            while (!queue.isEmpty()) {
                int cur=queue.poll();
            
                for (int next:list.get(cur)) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next]=true;
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}