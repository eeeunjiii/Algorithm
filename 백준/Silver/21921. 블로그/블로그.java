import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 블로그 사용 기간
        int X=Integer.parseInt(st.nextToken()); // X일 동안 가장 많이 들어온 방문자 수와 그 기간
        int[] arr=new int[N];

        // 최대 방문자가 0명인 경우, SAD 출력
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int sum=0;
        for(int i=0;i<X;i++) { // 첫 번쨰 구간에 대한 합
            sum+=arr[i];
        }

        int max=sum;
        int cnt=1;

        for(int i=0;i<N-X;i++) {
            sum+=arr[i+X];
            sum-=arr[i];

            if(sum==max) cnt++;
            if(max<sum) {
                cnt=1;
                max=sum;
            }
        }

        if(max==0) System.out.println("SAD");
        else System.out.println(max + "\n" + cnt);
    }
}