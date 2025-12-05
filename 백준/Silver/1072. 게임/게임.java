import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X=Integer.parseInt(st.nextToken());
        int Y=Integer.parseInt(st.nextToken());
        int Z=getPercent(X, Y);

        int start=0;
        int end=(int) 1e9;
        int ans=-1;
        while(start<=end) {
            int mid=(start+end)/2;

            if(getPercent(X+mid, Y+mid)!=Z) {
                ans=mid;
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        System.out.println(ans);
    }

    static int getPercent(int x, int y) {
        return (int) ((long)y*100/x);
    }
}