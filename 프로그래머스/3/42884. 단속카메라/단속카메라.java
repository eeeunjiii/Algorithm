import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        
        int camera=Integer.MIN_VALUE;
        int answer=0;
        
        for (int[] route:routes) {
            if (camera<route[0]) {
                camera=route[1];
                answer++;
            }
        }
        return answer;
    }
}