class Solution {
    static int[] answer = new int[2];
    
    private static boolean zip(int[][] arr, int x, int y, int size, int val){ // 압축 가능 판단
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[i][j]!=val) return false;
            }
        }
        return true;
    }
    
    private static void quad(int[][] arr, int x, int y, int size){ // 분할
        if(zip(arr, x, y, size, arr[x][y])){ // 압축 가능한 경우
            if(arr[x][y]==0) answer[0]++;
            else answer[1]++;
            return ;
        }
        
        // 압축이 불가능한 경우 -> 분할
        quad(arr, x, y, size/2);
        quad(arr, x, y+size/2, size/2);
        quad(arr, x+size/2, y, size/2);
        quad(arr, x+size/2, y+size/2, size/2);
    }
    
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return answer;
    }
}