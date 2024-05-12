import java.util.*;

class Solution {
    
    private static int n, m;
    private static int[] fuel;
    private static final int[] dr={-1,1,0,0};
    private static final int[] dc={0,0,-1,1};
    
    public int solution(int[][] land) {
        int answer = 0; // 석유량 반환
        
        n=land.length; // 세로 길이 (행)
        m=land[0].length; // 가로 길이 (열)
        fuel=new int[m]; // 각 열에 대해 시추할 수 있는 석유량
        boolean[][] visited=new boolean[n][m];
        
        // 열에 해당하는 모든 요소들에 대해 bfs를 적용시키기.
        // 석유 덩어리의 크기는 검정색 한 칸의 개수와 동일하다. (1: 석유가 있는 땅)
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(land[i][j]==1 && !visited[i][j]) {
                    bfs(i, j, visited, land);
                }
            }
        }
        answer=Arrays.stream(fuel).max().getAsInt();
        System.out.println(answer);
        return answer;
    }
    
    private static void bfs(int r, int c, boolean[][] visited, int[][] land) {
        int cnt=1;
        
        Queue<int[]> queue=new LinkedList<>();
        
        queue.offer(new int[]{r,c});
        visited[r][c]=true;
        
        Set<Integer> set=new HashSet<>(); // 석유 덩어리의 열 위치 저장
        
        while(!queue.isEmpty()) {
            int[] v=queue.poll();
            set.add(v[1]);
            
            for(int i=0;i<4;i++) {
                int nr=v[0]+dr[i];
                int nc=v[1]+dc[i];
                
                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
                if(!visited[nr][nc] && land[nr][nc]==1) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc]=true;
                    cnt++;
                }
            }
        }
        for(int index:set) {
            fuel[index]+=cnt;
        }
    }
}