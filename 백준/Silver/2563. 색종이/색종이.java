import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[][] paper=new int[N][2];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            paper[i][0]=a;
            paper[i][1]=b;
        }
        boolean[][] board=new boolean[101][101];

        int cnt=0;
        for(int i=0;i<N;i++) {
            int row=paper[i][0];
            int col=paper[i][1];

            for(int r=row;r<row+10;r++) {
                for(int c=col;c<col+10;c++) {
                    if(!board[r][c]) {
                        board[r][c]=true;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}