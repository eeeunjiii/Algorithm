import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] r_dp;
    private static int[] l_dp;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        r_dp =new int[N];
        l_dp=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        // 오름차순
        for(int i=0;i<N;i++){
            r_dp[i]=1; // i 번째 이전에 작은 값이 없다면 자기 자신 하나만 존재

            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && r_dp[j]+1>r_dp[i]){
                    r_dp[i]=r_dp[j]+1;
                }
            }
        }

        // 내림차순
        for(int i=N-1;i>=0;i--){
            l_dp[i]=1; // i 번째 이후에 (인덱스상으로) 큰 값이 없다면 자기 자신 하나만 존재

            for(int j=N-1;j>i;j--){
                if(arr[j]<arr[i] && l_dp[j]+1>l_dp[i]){
                    l_dp[i]=l_dp[j]+1;
                }
            }
        }

        int max=0;
        for(int i=0;i<N;i++){
            max=Math.max(max, l_dp[i]+r_dp[i]);
        }
        System.out.println(max-1); // 오름차순, 내림차순에서 숫자들이 하나씩 겹치기 때문에 -1 처리
    }
}