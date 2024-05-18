import java.util.*;

class Solution {
    
    private static int N;
    private static int M;
    private static int[] answer=new int[2];
    
    public int[] solution(String[] park, String[] routes) {
        N=park.length; // 행의 개수 (세로)
        M=park[0].length(); // 열의 개수 (가로)
        
        int startRow=0;
        int startCol=0;
        
        char[][] map=new char[N][M];
        
        // 1. park를 char 타입의 이차원 배열로 변환하기
        // 2. 'S'에서 시작해서 routes의 크기만큼 반복문을 진행한다.
        // 3. 'X'인 장애물을 만나면 그 명령은 실행하지 않고 그 다음 명령을 실행한다
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                map[i][j]=park[i].charAt(j);
                
                if(map[i][j]=='S') {
                    startRow=i;
                    startCol=j;
                }
            }
        }
        Map<Character, int[]> direction=new HashMap<>();
        direction.put('E', new int[]{0,1});
        direction.put('W', new int[]{0,-1});
        direction.put('S', new int[]{1,0});
        direction.put('N', new int[]{-1,0});
        
        for(String route:routes) {
            char D=route.charAt(0);
            int num=Character.getNumericValue(route.charAt(2));
            
            int nx=startRow;
            int ny=startCol;
            
            boolean check=true;
            
            int v[]=direction.get(D);
            
            for(int i=0;i<num;i++) {
                int tempRow=startRow+v[0];
                int tempCol=startCol+v[1];
                
                if(tempRow<0 || tempCol<0 || tempRow>=N || tempCol>=M) {
                    check=false;
                    break;
                }
                
                if(map[tempRow][tempCol]=='X') {
                    check=false;
                    break;
                }
                
                // map[tempRow][tempCol]='S';
                map[startRow][startCol]='O';
                startRow=tempRow;
                startCol=tempCol;
            }
            
            if(!check) {
                startRow=nx;
                startCol=ny;
            }
        }
        
        answer[0]=startRow;
        answer[1]=startCol;
        
        return answer;
    }
}