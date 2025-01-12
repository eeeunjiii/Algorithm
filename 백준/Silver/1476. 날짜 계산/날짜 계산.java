import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int E=Integer.parseInt(st.nextToken()); // 1-15
        int S=Integer.parseInt(st.nextToken()); // 1-28
        int M=Integer.parseInt(st.nextToken()); // 1-19

        int e=1;
        int s=1;
        int m=1;
        int cnt=1;

        while(true) {
            if(e==E && s==S && m==M) break;

            e++;
            s++;
            m++;
            cnt++;

            if(e>=16) e=1;
            if(s>=29) s=1;
            if(m>=20) m=1;
        }

        System.out.println(cnt);
    }
}