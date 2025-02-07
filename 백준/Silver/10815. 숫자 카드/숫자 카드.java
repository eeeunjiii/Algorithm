import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] num=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }

        int M=Integer.parseInt(br.readLine());
        int[] card=new int[M];
        int[] ans=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            card[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        for(int i=0;i<M;i++) {
            int target=card[i];

            int left=0;
            int right=N-1;
            int mid=0;

            while(left<=right) {
                mid=(left+right)/2;
                if(num[mid]==target) {
                    ans[i] = 1;
                    break;
                }
                else if(num[mid]<target) left=mid+1;
                else right=mid-1;
            }
        }

        for(int i=0;i<M;i++) {
            System.out.println(ans[i]);
        }
    }
}