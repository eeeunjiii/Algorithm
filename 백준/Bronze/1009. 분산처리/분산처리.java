import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int T=Integer.parseInt(br.readLine());
        while(T-->0) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            int prev=1;

            for(int i=0;i<b;i++) {
                prev=(prev*a)%10;
            }
            if(prev==0) prev=10;
            
            sb.append(prev).append("\n");
        }
        System.out.println(sb);
    }
}