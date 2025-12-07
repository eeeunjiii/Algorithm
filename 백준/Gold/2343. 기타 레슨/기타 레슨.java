import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] video=new int[N];

        // 수용 가능한 크기를 탐색해야 함!!
        long start=0;
        long end=0;
        int total=0;

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            video[i]=Integer.parseInt(st.nextToken());
            total+=video[i];
            start=Math.max(start, video[i]);
        }
        end=total;

        while(start<=end) {
            int cnt=1;
            long sum=0;
            long mid=(start+end)/2;

            for(int i=0;i<N;i++) {
                sum+=video[i];
                if(sum>mid) {
                    sum=video[i]; // sum이 기준치인 mid보다 커지면 그 부분부터 다시 더할 수 있도록 초기화
                    cnt++;
                }
            }

            if(cnt<=M) { // 필요한 블루레이 개수보다 작거나 같으면
                end=mid-1; // 더 작은 크기로 쪼개기
            } else {
                start=mid+1;
            }
        }
        System.out.println(start);
    }
}