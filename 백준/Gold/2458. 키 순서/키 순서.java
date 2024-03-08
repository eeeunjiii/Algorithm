import java.io.*;
import java.util.*;

public class Main {
    private static int N; // 학생 수
    private static int M; // 비교 횟수
    private static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        graph=new int[N+1][N+1];

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a][b]=1;
        }

        for(int i=1;i<=N;i++) { // 중간 지점
            for(int j=1;j<=N;j++) { // 시작 지점
                if(i==j) continue;

                for(int k=1;k<=N;k++) { // 도착 지점
                    if(i==k || j==k) continue;
                    if(graph[j][i]==1 && graph[i][k]==1) {
                        graph[j][k]=1;
                    }
                }
            }
        }

        int ans=0;

        for(int i=1;i<=N;i++) {
            int cnt=0;
            for(int j=1;j<=N;j++) {
                if(graph[i][j]==1 || graph[j][i]==1) cnt++;
            }
            if(cnt==N-1) ans++;
        }
        System.out.println(ans);
    }
}