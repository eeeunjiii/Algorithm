import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr=new int[N+1];

        for (int i=1;i<=N;i++) {
            arr[i]=i;
        }

        for (int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());

            int first=Integer.parseInt(st.nextToken()); // 교체할 인덱스
            int second=Integer.parseInt(st.nextToken());
            int temp=0;

            temp=arr[first];
            arr[first]=arr[second];
            arr[second]=temp;
        }

        for (int i=1;i<=N;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}