import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] arr=new int [N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum=0;
        int start=0;
        int end=0;
        int answer=0;

        while(start<N) {
            if(sum>M || end==N) {
                sum-=arr[start];
                start++;
            } else {
                sum+=arr[end];
                end++;
            }
            
            if(sum==M) answer++;
        }
        System.out.println(answer);
    }
}
