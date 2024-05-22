class Solution {
    public int solution(String[] board) {
        // 선공이 'O', 후공이 'X'
        int ans=0;
        
        char[][] newBoard=new char[3][3];
        int firstCnt=0; // 'O'
        int lastCnt=0; // 'X'
        
        for(int i=0;i<board.length;i++) { // 개수 계산
            for(int j=0;j<board[0].length();j++) {
                newBoard[i][j]=board[i].charAt(j);
                if(newBoard[i][j]=='O') firstCnt++;
                else if(newBoard[i][j]=='X') lastCnt++;
            }
        }
        
        if(lastCnt>firstCnt || firstCnt>lastCnt+1) return 0;
        
        boolean firstWin=check('O', newBoard);
        boolean lastWin=check('X', newBoard);
        
        if(firstWin && lastCnt+1 != firstCnt) return 0;
        if(lastWin && lastCnt!=firstCnt) return 0;
        
        return 1;
    }
    
    private boolean check(char target, char[][] map) {
        for(int i=0;i<3;i++) {
            if(map[i][0]==target && map[i][1]==target && map[i][2]==target) return true;
        }
        
        for(int i=0;i<3;i++) {
            if(map[0][i]==target && map[1][i]==target && map[2][i]==target) return true;
        }
        
        if(map[0][0]==target && map[1][1]==target && map[2][2]==target) return true;
        
        if(map[2][0]==target && map[1][1]==target && map[0][2]==target) return true;
        
        return false;
    }
}