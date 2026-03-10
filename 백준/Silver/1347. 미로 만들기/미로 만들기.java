import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr={-1, 0, 1, 0}; // 북 동 남 서
    static final int[] dc={0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        char[] arr=br.readLine().toCharArray();
        char[][] board=new char[100][100];

        int r=50;
        int c=50;
        int maxR=50;
        int minR=50;
        int maxC=50;
        int minC=50;

        board[r][c]=1;

        int dir=2; // 남쪽을 바라보고 있음
        for (int i=0;i<N;i++) {
            if (arr[i]=='L') {
                dir--;
                if (dir==-1) dir=3;
            } else if (arr[i]=='R') {
                dir=(dir+1)%4;
            } else if (arr[i]=='F') {
                r+=dr[dir];
                c+=dc[dir];

                maxR=Math.max(r, maxR);
                maxC=Math.max(c, maxC);
                minR=Math.min(r, minR);
                minC=Math.min(c, minC);

                board[r][c]=1;
            }
        }

        StringBuilder sb=new StringBuilder();
        for (int i=minR;i<=maxR;i++) {
            for (int j=minC;j<=maxC;j++) {
                if (board[i][j]==1) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}