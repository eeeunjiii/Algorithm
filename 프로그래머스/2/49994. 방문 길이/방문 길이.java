class Solution {
    
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    
    public int solution(String dirs) {
        boolean[][][] visited=new boolean[11][11][4];
        
        int x=5, y=5, d=0;
        int ans=0;
        
        for (char ch:dirs.toCharArray()) {
            if (ch=='U') d=0;
            if (ch=='R') d=1;
            if (ch=='D') d=2;
            if (ch=='L') d=3;
            
            int nx=x+dx[d];
            int ny=y+dy[d];
            
            if (nx<0 || ny<0 || nx>=11 || ny>=11) continue;
            if (!visited[nx][ny][d]) {
                visited[nx][ny][d]=true;
                visited[x][y][(d+2)%4]=true;
                ans++;
            }
            x=nx;
            y=ny;
        }
        return ans;
    }
}