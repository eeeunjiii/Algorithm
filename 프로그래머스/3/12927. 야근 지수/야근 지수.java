import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2) -> o2-o1);
        
        int sum=0;
        for (int i=0;i<works.length;i++) {
            sum+=works[i];
        }
        
        if (sum<n) return 0;
        
        for (int i=0;i<works.length;i++) {
            pq.offer(works[i]);
        }
        
        for (int i=0;i<n;i++) {
            int cur=pq.poll()-1;
            pq.offer(cur);
        }
        
        long answer=0L;
        while (!pq.isEmpty()) {
            int v=pq.poll();
            answer+=v*v;
        }
        
        return answer;
    }
}