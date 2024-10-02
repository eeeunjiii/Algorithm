import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String num=br.readLine();
        int[] cnt=new int[10];

        for(int i=0;i<num.length();i++) {
            char c=num.charAt(i);
            if(c-'0'==6) cnt[9]++;
            else cnt[c-'0']++;
        }

        int max=0;
        for(int i=0;i<9;i++) {
            max=Math.max(max, cnt[i]);
        }

        int sum=cnt[9]/2;
        if(cnt[9]%2!=0) sum++;

        max=Math.max(max, sum);
        System.out.println(max);
    }
}