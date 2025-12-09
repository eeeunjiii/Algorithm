import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken()); // 상근이가 가지고 있는 CD의 수
            M=Integer.parseInt(st.nextToken()); // 선영이가 가지고 있는 CD의 수
            arr=new int[N];
            int ans=0;

            if(N==0 && M==0) break;

            for(int i=0;i<N;i++) {
                arr[i]=Integer.parseInt(br.readLine());
            }
            for(int i=0;i<M;i++) {
                ans+=binarySearch(Integer.parseInt(br.readLine()));
            }
            System.out.println(ans);
        }
    }

    static int binarySearch(int target) {
        int start=0;
        int end=N-1;

        while(start<=end) {
            int mid=(start+end)/2;

            if(arr[mid]==target) {
                return 1;
            }

            if(arr[mid]<target) {
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return 0;
    }
}