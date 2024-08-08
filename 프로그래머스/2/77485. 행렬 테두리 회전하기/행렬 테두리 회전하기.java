class Solution {
    
    static int[][] board;
    static int[][] copyBoard;
    static int min;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        board = new int[rows][columns];
        copyBoard = new int[rows][columns];
        
        // x: 행, y: 열
        // 중앙은 회전 X
        
        int num=1;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                board[i][j]=copyBoard[i][j]=num++;
            }
        }
        
        int idx=0;
        for(int i=0;i<queries.length;i++) {
            int minRow=queries[i][0]-1;
            int minCol=queries[i][1]-1;
            int maxRow=queries[i][2]-1;
            int maxCol=queries[i][3]-1;
            
            min=Integer.MAX_VALUE;
            
            roateBoard(minRow, minCol, maxRow, maxCol);
            updateBoard();
            
            answer[idx++]=min;
        }
        
        return answer;
    }
    
    private void roateBoard(int minRow, int minCol, int maxRow, int maxCol) {
        for(int i=minRow+1;i<=maxRow;i++) {
            board[i][maxCol]=copyBoard[i-1][maxCol];
            min=Math.min(min, board[i][maxCol]);
        }
        for(int i=maxCol-1;i>=minCol;i--) {
            board[maxRow][i]=copyBoard[maxRow][i+1];
            min=Math.min(min, board[maxRow][i]);
        }
        for(int i=maxRow-1;i>=minRow;i--) {
            board[i][minCol]=copyBoard[i+1][minCol];
            min=Math.min(min, board[i][minCol]);
        }
        for(int i=minCol+1;i<=maxCol;i++) {
            board[minRow][i]=copyBoard[minRow][i-1];
            min=Math.min(min, board[minRow][i]);
        }
    }
    
    private void updateBoard() {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                copyBoard[i][j]=board[i][j];
            }
        }
    }
}