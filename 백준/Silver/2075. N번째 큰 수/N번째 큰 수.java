import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());

        int N=Integer.parseInt(br.readLine());
        long[][] arr=new long[N][N];


        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j]=Long.parseLong(st.nextToken());
                pq.add(arr[i][j]);
            }
        }

        long ans=0;
        for(int i=0;i<N;i++) {
            ans=pq.poll();
        }
        System.out.println(ans);
    }
}
