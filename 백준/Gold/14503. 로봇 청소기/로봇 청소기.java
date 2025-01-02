import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] board;
    private final static int[] dr={-1,0,1,0}; // 북동남서
    private final static int[] dc={0,1,0,-1};
    private static int cnt=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new int[N][M];

        st=new StringTokenizer(br.readLine());
        // d==0: 북, 1: 동, 2: 남, 3: 서 -> 로봇 청소기가 바라보고 있는 방향
        int r=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // 0: 청소되지 않은 빈 칸, 1: 벽 (이동 불가),  2: 청소된 칸
        // 바라보는 방향의 뒤쪽 칸이 벽이라면 작동 중딘 -> 이때까지 청소된 영역의 개수
        cleanRoom(r,c,d);
        System.out.println(cnt);
    }

    private static void cleanRoom(int r, int c, int d) {
        board[r][c]=-1;

        for(int i=0;i<4;i++) { // 청소되지 않은 빈 칸이 있어 회전하고 전진하는 경우
            d=(d+3)%4;

            int nr=r+dr[d];
            int nc=c+dc[d];

            if(nr<0 || nc<0 || nr>=N || nc>=M) continue;

            if(board[nr][nc]==0) {
                cnt++;
                cleanRoom(nr, nc, d);
                return;
            }
        }

        int dir=(d+2)%4; // 반대방향으로 후진
        int new_r=r+dr[dir];
        int new_c=c+dc[dir];

        if(new_r>=0 && new_c>=0 && new_r<N && new_c<M && board[new_r][new_c]!=1) {
            cleanRoom(new_r, new_c, d);
        }
    }
}