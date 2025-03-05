import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] num=new int[N];
        int[] dp=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }

        dp[0]=num[0];

        int len=1;
        for(int i=1;i<N;i++) {
            int target=num[i];

            if(dp[len-1]<target) {
                len++;
                dp[len-1]=target;
            } else {
                int low=0;
                int high=len;

                while(low<high) {
                    int mid=(low+high)/2;

                    if(dp[mid]<target) {
                        low=mid+1;
                    } else {
                        high=mid;
                    }
                }
                dp[low]=target;
            }
        }
        System.out.println(len);
    }
}