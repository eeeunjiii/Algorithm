import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine()); // 굴다리의 길이 (모두 빛으로 밝아져야 함)
        int M=Integer.parseInt(br.readLine()); // 가로등의 개수
        int[] light=new int[M]; // 가로등의 위치

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            light[i]=Integer.parseInt(st.nextToken());
        }

        int left=1;
        int right=N;
        int ans=0;
        while(left<=right) {
            int mid=(left+right)/2;

            if(check(mid, light)) {
                right=mid-1;
                ans=mid;
            } else {
                left=mid+1;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int h, int[] light) {
        int prev=0;

        for(int i=0;i<light.length;i++) {
            if(light[i]-h<=prev) {
                prev=light[i]+h;
            } else return false;
        }
        return N-prev<=0;
    }
}