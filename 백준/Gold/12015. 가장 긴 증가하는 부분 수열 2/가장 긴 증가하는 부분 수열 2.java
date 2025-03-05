import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] num=new int[N];
        int[] LIS=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }

        LIS[0]=num[0];
        int len=1;

        for(int i=1;i<N;i++) {
            int target=num[i];

            if(LIS[len-1]<target) { // 추가
                len++;
                LIS[len-1]=target;
            } else {
                int low=0;
                int high=len;

                while(low<high) { // 요소를 대치하는 과정에서 이분 탐색 사용
                    int mid=(low+high)/2;

                    if(LIS[mid]<target) {
                        low=mid+1;
                    } else {
                        high=mid;
                    }
                }
                LIS[high]=target;
            }
        }
        System.out.println(len);
    }
}
