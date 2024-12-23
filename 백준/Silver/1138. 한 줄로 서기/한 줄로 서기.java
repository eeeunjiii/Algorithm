import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        int[] ans=new int[N];
        Arrays.fill(ans, -1);

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++) {
            int num=arr[i];

            int cnt=0;
            for(int j=0;j<N;j++) {
                if(ans[j]==-1) {
                    if(num==cnt) {
                        ans[j]=i+1;
                        break;
                    }
                    cnt++;
                }
            }
        }

        for(int i=0;i<N;i++) {
            System.out.print(ans[i]+" ");
        }
    }
}