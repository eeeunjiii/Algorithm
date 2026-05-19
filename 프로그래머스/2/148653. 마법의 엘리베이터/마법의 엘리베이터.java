class Solution {
    public int solution(int storey) {
        int ans=0;
        
        while (storey>0) {
            int num=storey%10;
            storey/=10;
            
            if (num>5) {
                ans+=10-num;
                storey++;
            } else if (num<5) {
                ans+=num;
            } else if (storey%10>=5) {
                ans+=5;
                storey++;
            } else {
                ans+=5;
            }
        }
        return ans;
    }
}