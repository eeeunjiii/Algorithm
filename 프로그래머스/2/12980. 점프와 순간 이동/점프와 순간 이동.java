import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int dist=n;
        
        while(dist!=0) {
            if(dist%2==0) {
                dist/=2;
            } else {
                dist-=1;
                ans++;
            }
        }

        return ans;
    }
}