import java.util.*;

class Solution {
    
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static int[][] board;
    static boolean[][] visited;
    static int N;
    static int M;
    
    public int[] solution(String[] maps) {
        N=maps.length;
        M=maps[0].length();
        
        board=new int[N][M];
        visited=new boolean[N][M];
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(maps[i].charAt(j)=='X') {
                    board[i][j]=0;
                } else {
                    board[i][j]=maps[i].charAt(j)-'0';
                }
            }
        }
        
        int num=0;
        List<Integer> list=new ArrayList<>();
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(!visited[i][j] && board[i][j]!=0) {
                    num++;
                    list.add(bfs(i, j));
                }
            }
            
        }
        Collections.sort(list);
        
        if(list.size()==0) return new int[] {-1};
        
        int[] answer=list.stream()
            .mapToInt(i->i)
            .toArray();
        
        return answer;
    }
    
    static int bfs(int x, int y) {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y]=true;
        
        int sum=board[x][y];
        
        while(!queue.isEmpty()) {
            int[] now=queue.poll();
            
            for(int i=0;i<4;i++) {
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(!visited[nx][ny] && board[nx][ny]!=0) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny]=true;
                    sum+=board[nx][ny];
                }
            }
        }
        
        return sum;
    }
}