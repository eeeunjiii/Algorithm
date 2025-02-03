import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 분석 대상 전체 광고 지면의 수
        int K=Integer.parseInt(st.nextToken()); // 목표 낙찰 지면 수
        int[][] ads=new int[N][2]; // 0: 광고 지면 i에 대해 moloco가 제시한 입찰 가격, 1: 제시한 입찰가격을 제외하고 다른 모든 입찰가 중 최고 가격

        // moloco가 입찰가를 X만큼 일괄적으로 올렸을 때, K개 이상의 지면을 낙찰 받게 되는 가장 작은 음이 아닌 정수 X를 찾아야 함
        // 동일한 가격이라면 moloco가 낙찰됨

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            ads[i][0]=Integer.parseInt(st.nextToken());
            ads[i][1]=Integer.parseInt(st.nextToken());
        }

        int[] minus=new int[N];
        for(int i=0;i<N;i++) {
            minus[i]=ads[i][1]-ads[i][0];
        }

        Arrays.sort(minus);

        int cnt=0;
        int idx=0;
        for(int i=0;i<N;i++) {
            if(minus[i]<=0) {
                cnt++;
                idx++;
            }
        }

        if(cnt>=K) System.out.println(0);
        else {
            System.out.println(minus[idx+K-cnt-1]);
        }
    }
}