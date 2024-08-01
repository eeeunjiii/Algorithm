class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int num = Math.max(arrayA[0], arrayB[0]);
        
        for(int i=2;i<=num;i++) {
            if((canDivide(arrayA, i) && canNotDivide(arrayB, i)) ||
              canDivide(arrayB, i) && canNotDivide(arrayA, i)) {
                answer=i;
            }
        }
        
        return answer;
    }
    
    static boolean canDivide(int[] array, int num) {
        for(int v:array) {
            if(v%num==0) continue;
            else return false;
        }
        return true;
    }
    
    static boolean canNotDivide(int[] array, int num) {
        for(int v:array) {
            if(v%num!=0) continue;
            else return false;
        }
        return true;
    }
}