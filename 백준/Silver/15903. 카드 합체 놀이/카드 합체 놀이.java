import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken()); // 카드 합체를 하는 횟수
        long[] arr=new long[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<M;i++) {
            arr[0]=arr[1]=arr[0]+arr[1];
            Arrays.sort(arr);
        }

        long sum=Arrays.stream(arr).sum();

        System.out.println(sum);
    }
}
