import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String document=br.readLine();
        String word=br.readLine();

        int max=Integer.MIN_VALUE;

        for(int i=0;i<document.length();i++) {
            int start=i;
            int cnt=0;

            while(start+word.length()<=document.length()) {
                if(document.substring(start, start + word.length()).equals(word)) {
                    cnt++;
                    start+=word.length();
                } else {
                    start++;
                }
            }
            max=Math.max(max, cnt);
        }
        System.out.println(max);
    }
}