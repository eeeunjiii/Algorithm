import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[] arr=new int[N+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i]=arr[i-1]+Integer.parseInt(st.nextToken()); // 누적합
        }

        int max=Integer.MIN_VALUE;
        for(int i=K;i<=N;i++) {
            int sum=arr[i]-arr[i-K];
            if(sum>max) max=sum;
        }
        System.out.println(max);
    }
}