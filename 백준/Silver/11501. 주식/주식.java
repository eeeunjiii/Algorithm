import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int T=Integer.parseInt(br.readLine());
        int[] arr;
        StringTokenizer st;

        for(int i=0;i<T;i++) {
            int N=Integer.parseInt(br.readLine());
            arr=new int[N];
            long ans=0;

            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[j]=Integer.parseInt(st.nextToken());
            }

            int max=arr[N-1]; // 가장 뒤에 있는 인덱스의 값부터 탐색
            for(int j=N-2;j>=0;j--) {
                if(arr[j]<=max) ans+=max-arr[j];
                else max=arr[j];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}