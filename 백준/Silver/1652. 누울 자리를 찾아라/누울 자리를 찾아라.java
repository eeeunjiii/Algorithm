import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        char[][] board=new char[N][N];

        for (int i=0;i<N;i++) {
            String line=br.readLine();

            for (int j=0;j<N;j++) {
                board[i][j]=line.charAt(j);
            }
        }

        // 연속해서 2칸 이상의 빈 칸이 존재하면 세로든 가로든 누울 수 있음.
        // 가로로 누울 수 있는 자리, 세로로 누울 수 있는 자리 개수 출력
        // 각 행, 열을 탐색하면 될 듯
        // .: 빈칸, X: 짐이 있는 곳

        int rowCnt=0;
        int colCnt=0;
        int rowCheck=0;
        int colCheck=0;

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (board[i][j]=='.') {
                    rowCheck++;
                    if (rowCheck==2) rowCnt++;
                } else {
                    rowCheck=0;
                }
            }
            rowCheck=0;
        }

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (board[j][i]=='.') {
                    colCheck++;
                    if (colCheck==2) colCnt++;
                } else {
                    colCheck=0;
                }
            }
            colCheck=0;
        }

        System.out.println(rowCnt+" "+colCnt);
    }
}