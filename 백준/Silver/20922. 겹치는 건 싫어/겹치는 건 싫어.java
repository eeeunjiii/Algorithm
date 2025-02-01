import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];
        int[] num=new int[100_001];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int ans=0;
        int start=0;
        int end=0;
        while (end < N) {
            while(end<N && num[arr[end]]+1<=K) {
                num[arr[end]]++;
                end++;
            }
            int len=end-start;
            ans=Math.max(ans, len);
            num[arr[start]]--;
            start++;
        }
        System.out.println(ans);
    }
}