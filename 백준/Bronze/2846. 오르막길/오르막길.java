import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] P=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            P[i]=Integer.parseInt(st.nextToken());
        }

        // 가장 큰 오르막길의 크기
        // 오르막길: 적어도 2개의 수로 이루어진 높이가 증가하는 부분 수열
        int start=0;
        int end=0;
        int ans=0;
        for (int i=1;i<=N-1;i++) {
            int cur=P[i];
            start=P[i];
            for (int j=i+1;j<=N;j++) {
                if (cur<P[j]) {
                    cur=P[j];
                    end=P[j];
                } else break;
            }
            ans=Math.max(ans, end-start);
        }
        System.out.println(ans);
    }
}