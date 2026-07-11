import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent=new int[n];
        
        for (int i=0;i<n;i++) {
            parent[i]=i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2]-o2[2]);
        
        int ans=0;
        for (int i=0;i<costs.length;i++) {
            if (find(costs[i][0])!=find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                ans+=costs[i][2];
            }
        }
        
        return ans;
    }
    
    static public int find(int x) {
        if (parent[x]==x) return parent[x];
        else return parent[x]=find(parent[x]);
    }
    
    static public void union(int a, int b) {
        a=find(a);
        b=find(b);
        
        if (a<b) {
            parent[b]=a;
        } else if (a>b) {
            parent[a]=b;
        }
    }
}