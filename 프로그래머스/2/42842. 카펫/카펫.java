class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum=brown+yellow;
        
        for(int i=3;i<sum/2;i++) {
            int j=sum/i;
            
            int row=Math.min(i,j);
            int col=Math.max(i,j);
            
            int center=(row-2)*(col-2);
            
            if(center==yellow) {
                answer=new int[] {col, row};
                return answer;
            }
        }
        return answer;
    }
}