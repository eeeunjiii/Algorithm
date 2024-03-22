import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] arr=new int[N]; // N장의 카드
        int max=Integer.MIN_VALUE;

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                for(int l=j+1;l<N;l++) {
                    int sum=arr[i]+arr[j]+arr[l];
                    if(sum<=M && sum>max) max=sum;
                }
            }
        }
        System.out.println(max);
    }
}