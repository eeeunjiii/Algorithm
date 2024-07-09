import java.util.*;

class Solution {
    
    static char[][] board;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        int[] start=new int[2];
        int[] lever=new int[2];
        
        // 출발 -> 레버 -> 출구, 미로 탈출 최소 시간
        board=new char[maps.length][maps[0].length()];
        
        for(int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[0].length();j++) {
                board[i][j]=maps[i].charAt(j);
                
                if(board[i][j]=='S') {
                    start=new int[]{i, j};
                }
                
                if(board[i][j]=='L') {
                    lever=new int[]{i, j};
                }
            }
        }
        
        int cntToLever=bfs(start, 'L');
        int cntToExit=bfs(lever, 'E');
        
        if(cntToLever==-1 || cntToExit==-1) return -1;
        
        return cntToLever+cntToExit;
    }
    
    public int bfs(int[] start, char target) {
        Queue<int[]> queue=new LinkedList<>();
        boolean[][] visited=new boolean[board.length][board[0].length];
        
        queue.add(new int[]{start[0], start[1], 0});
        
        while(!queue.isEmpty()) {
            int[] v=queue.poll();
            int x=v[0];
            int y=v[1];
            int cnt=v[2];
            
            visited[x][y]=true;
            
            if(board[x][y]==target) {
                return cnt;
            }
            
            for(int i=0;i<4;i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx<0 || ny<0 || nx>=board.length || ny>=board[0].length) continue;
                
                if(!visited[nx][ny] && board[nx][ny]!='X') {
                    queue.add(new int[]{nx, ny, cnt+1});
                    visited[nx][ny]=true;
                }
            }
        }
        return -1;
    }
}