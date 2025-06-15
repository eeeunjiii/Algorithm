import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N;
    static int[] requests;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine()); // 지방의 수
        requests=new int[N]; // 예산 요청
        int sum=0;
        int high=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            requests[i]=Integer.parseInt(st.nextToken());
            sum+=requests[i];
            high=Math.max(high, requests[i]);
        }

        int M=Integer.parseInt(br.readLine()); // 총 예산

        if(sum<=M) {
            System.out.println(high);
            return;
        }

        int low=1;

        while(low<=high) { // 이 부분을 왜 이렇게 하는지 모르겠음 high-1
            int mid=(low+high)/2;

            if(findLimitSum(mid)>M) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        System.out.println(high);
    }

    static int findLimitSum(int mid) {
        int total=0;
        for(int i=0;i<N;i++) {
            total+=Math.min(mid, requests[i]);
        }
        return total;
    }
}