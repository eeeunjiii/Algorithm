import java.util.*;

class Solution {
    static List<List<Integer>> list;
    
    public int solution(int n, int[][] wires) {
        // 두 전력망이 가지고 있는 송전탑 개수의 차이
        list=new ArrayList<>();
        for (int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i=0;i<wires.length;i++) {
            int v1=wires[i][0];
            int v2=wires[i][1];
            
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        int min=Integer.MAX_VALUE;
        for (int i=0;i<wires.length;i++) {
            int v1=wires[i][0];
            int v2=wires[i][1];
            
            list.get(v1).remove(Integer.valueOf(v2));
            list.get(v2).remove(Integer.valueOf(v1));
            
            boolean[] visited=new boolean[n+1];
            
            int cnt=dfs(1, visited);
            int diff=Math.abs(cnt-(n-cnt));
            
            min=Math.min(min, diff);
            
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        return min;
    }
    
    public int dfs(int v, boolean[] visited) {
        visited[v]=true;
        
        int cnt=1;
        for (int next:list.get(v)) {
            if (!visited[next]) {
                cnt+=dfs(next, visited);
            }
        }
        return cnt;
    }
}