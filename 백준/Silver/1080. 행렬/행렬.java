import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 행
        int M=Integer.parseInt(st.nextToken()); // 열

        int[][] A=new int[N][M];
        int[][] B=new int[N][M];

        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<M;j++){
                A[i][j]=str.charAt(j)-'0';
            }
        }
        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<M;j++){
                B[i][j]=str.charAt(j)-'0';
            }
        }

        int cnt=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(A[i][j]!=B[i][j] && i+2<N && j+2<M){
                    for(int x=i;x<i+3;x++){
                        for(int y=j;y<j+3;y++){
                            if(A[x][y]==0) A[x][y]=1;
                            else A[x][y]=0;
                        }
                    }
                    cnt++;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(A[i][j]!=B[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }
}