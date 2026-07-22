import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx=0;
        int bIdx=0;
        int ans=0;
        
        // 1, 3, 5, 7
        // 2, 2, 6, 8
        
        while (aIdx<A.length && bIdx<B.length) {
            if (B[bIdx]>A[aIdx]) {
                ans++;
                aIdx++;
                bIdx++;
            } else {
                bIdx++;
            }
        }
        return ans;
    }
}