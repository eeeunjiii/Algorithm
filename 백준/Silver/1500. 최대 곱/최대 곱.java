import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int S=Integer.parseInt(st.nextToken()); // 13
        int K=Integer.parseInt(st.nextToken()); // 8

        int div=S/K; // 1
        int mod=S%K; // 5
        long max=1; // 2, 2, 2, 2, 2, 

        for (int i=1;i<=K;i++) {
            if (i<=mod) {
                max*=(div+1);
            } else {
                max*=div;
            }
        }
        System.out.println(max);
    }
}