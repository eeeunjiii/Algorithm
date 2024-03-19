import java.io.*;
import java.util.*;

public class Main {

    private static final int r=31;
    private static final int M=1234567891;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());

        int L=Integer.parseInt(br.readLine());
        String str=br.readLine();

        int[] alpha=new int[26];
        for(int i=0;i<26;i++) {
            alpha[i]=i+1;
        }

        int ans=0;
        for(int i=0;i<L;i++) {
            ans+= (int) (alpha[str.charAt(i)-'a']*Math.pow(r, i));
        }
        System.out.println(ans%M);
    }
}