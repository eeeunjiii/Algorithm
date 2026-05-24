class Solution {
    static long ans=0;
    
    public long solution(int[] seq) {
        int N=seq.length;
        
        int[] seq1=new int[N];
        for (int i=0;i<N;i++) {
            if (i%2==0) seq1[i]=-seq[i];
            else seq1[i]=seq[i];
        }
        
        int[] seq2=new int[N];
        for (int i=0;i<N;i++) {
            if (i%2==0) seq2[i]=seq[i];
            else seq2[i]=-seq[i];
        }
        
        findMax(N, seq1);
        findMax(N, seq2);
        
        return ans;
    }
    
    static void findMax(int N, int[] seq) {
        long total=0;
        
        for (int L=0, R=0;L<N;L++) {
            while (total>=0 && R<N) {
                total+=seq[R];
                ans=Math.max(total, ans);
                R++;
            }
            total-=seq[L];
        }
    }
}