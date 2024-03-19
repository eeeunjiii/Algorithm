import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());

        int L=Integer.parseInt(br.readLine());
        String str=br.readLine();

        int[] alpha=new int[26];
        for(int i=0;i<26;i++) {
            alpha[i]=i+1;
        }
        long r=1;
        int M=1234567891;
        long ans=0;

        for(int i=0;i<L;i++) {
            ans+=((str.charAt(i)-'a'+1)*r)%M;
            r=(r*31)%M;
        }
        System.out.println(ans%M);
    }
}