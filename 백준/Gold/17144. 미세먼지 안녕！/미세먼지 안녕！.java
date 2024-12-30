import java.io.*;
import java.util.*;

public class Main {

    private static int R;
    private static int C;
    private static int T;
    private static int[][] board;
    private static int air1, air2;
    private static final int[] dr={-1,1,0,0};
    private static final int[] dc={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        board=new int[R][C];

        // 1. 모든 방향으로 A/5씩 확산 (원래 있던 칸에서는 A-A/5*확산된 칸의 개수가 저장됨). 한 칸씩. 공기청정기 칸 == -1
        // 2. 공기청정기 작동 -> rotate

        for(int i=0;i<R;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        findAir();

        while(T-->0) {
            board=diffuse();
            upRotate();
            downRotate();
        }

        System.out.println(sum()+2); // 공기청정기 부분이 -2가 되었기 때문에 +2
    }

    private static void findAir() {
        for(int i=0;i<R;i++) {
            if(board[i][0]==-1) {
                air1=i;
                air2=i+1;
                break;
            }
        }
    }

    private static int[][] diffuse() {
        int[][] temp=new int[50][50];
        for(int r=0;r<R;r++) {
            for(int c=0;c<C;c++) {
                if(board[r][c]==-1) {
                    temp[r][c]=-1;
                    continue;
                }

                temp[r][c]+=board[r][c];

                for(int d=0;d<4;d++) {
                    int nr=r+dr[d];
                    int nc=c+dc[d];

                    if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
                    if(board[nr][nc]==-1) continue;

                    temp[nr][nc]+=(board[r][c]/5);
                    temp[r][c]-=(board[r][c]/5);
                }
            }
        }
        return temp;
    }

    private static void upRotate() {
        int top=air1;

        for (int x = top - 1; x > 0; x--) {
            board[x][0] = board[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            board[0][y] = board[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            board[x][C - 1] = board[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            board[top][y] = board[top][y - 1];
        }

        board[top][1]=0;
    }

    private static void downRotate () {
        int bottom=air2;

        for (int x = bottom + 1; x < R - 1; x++) {
            board[x][0] = board[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            board[R - 1][y] = board[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottom; x--) {
            board[x][C - 1] = board[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            board[bottom][y] = board[bottom][y - 1];
        }

        board[bottom][1]=0;
    }

    private static int sum() {
        int sum=0;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                sum+=board[i][j];
            }
        }
        return sum;
    }
}