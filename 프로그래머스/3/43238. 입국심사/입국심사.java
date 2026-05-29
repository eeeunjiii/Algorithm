import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int len=times.length;
        long ans=0;
        
        Arrays.sort(times);
        
        long left=0;
        long right=times[len-1]*(long) n;
        
        while (left<=right) {
            long mid=(left+right)/2;
            long complete=0;
            
            for (int i=0;i<len;i++) {
                complete+=mid/times[i];
            }
            
            if (complete<n) {
                left=mid+1;
            } else {
                right=mid-1;
                ans=mid;
            }
        }
        return ans;
    }
}