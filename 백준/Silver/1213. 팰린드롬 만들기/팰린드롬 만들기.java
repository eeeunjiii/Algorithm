import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String str=br.readLine();
        int[] num=new int[26];

        for(int i=0;i<str.length();i++){
            num[str.charAt(i)-'A']++;
        }

        int check=0;
        for(int i=0;i<num.length;i++){
            if(num[i]%2!=0) check++;
        }

        String ans="";

        if(check>1) ans+="I'm Sorry Hansoo";
        else{
            for(int i=0;i<26;i++){
                for(int j=0;j<num[i]/2;j++){
                    sb.append((char)(i+'A'));
                }
            }

            ans+=sb.toString();
            String end=sb.reverse().toString();

            sb=new StringBuilder();

            for(int i=0;i<num.length;i++){
                if(num[i]%2!=0){
                    sb.append((char)(i+'A'));
                }
            }
            ans += sb.toString()+end;
        }
        System.out.println(ans);
    }
}