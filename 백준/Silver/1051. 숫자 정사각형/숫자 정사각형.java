import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 세로
        int M=Integer.parseInt(st.nextToken()); // 가로
        int[][] arr=new int[N][M];

        for (int i=0;i<N;i++) {
            String line=br.readLine();
            for (int j=0;j<line.length();j++) {
                arr[i][j]=line.charAt(j)-'0';
            }
        }

        int min=Math.min(N, M);

        if (min==1) {
            System.out.println(1);
            return;
        }

        // 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형 넓이 찾기
        // 모두 요소가 같은 숫자일 필요 없이 꼭짓점만 동일하면 됨
        // 정사각형 한 변의 길이는 1부터 Math.min(N, M)까지 가능

        for (int l=min-1;l>=1;l--) {
            for (int i=0;i<N;i++) {
                for (int j=0;j<M;j++) {
                    int start=arr[i][j];

                    if (i+l>=N || j+l>=M) continue;
                    if (start==arr[i+l][j] && start==arr[i][j+l]
                            && start==arr[i+l][j+l]) {
                        System.out.println((l+1)*(l+1));
                        return;
                    }
                }
            }
        }
        System.out.println(1);
    }
}