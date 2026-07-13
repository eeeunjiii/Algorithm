class Solution {
    static public int N;
    
    public long solution(int[] seq) {
        N=seq.length;
        
        int[] seq1=new int[N];
        int[] seq2=new int[N];
        
        for (int i=0;i<N;i++) {
            if (i%2==0) {
                seq1[i]=-seq[i];
                seq2[i]=seq[i];
            }
            else {
                seq1[i]=seq[i];
                seq2[i]=-seq[i];
            }
        }
        
        return Math.max(findMax(seq1), findMax(seq2));
    }
    
    static public long findMax(int[] seq) {
        long[] prefix=new long[N+1];
        
        for (int i=0;i<N;i++) { // 부분 수열 중 누적합이 가장 큰 것-가장 작은 것
            prefix[i+1]=prefix[i]+seq[i];
        }
        
        long max=prefix[0];
        long min=prefix[0];
        
        for (int i=0;i<=N;i++) {
            if (max<prefix[i]) max=prefix[i];
            if (min>prefix[i]) min=prefix[i];
        }
        
        return max-min;
    }
}