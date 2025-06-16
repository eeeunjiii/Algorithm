import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String password;
        char[] word;
        String acc="> is acceptable.\n";
        String not="> is not acceptable.\n";
        boolean flag;
        char prev;
        int count;

        while(!(password=br.readLine()).equals("end")) {
            word=password.toCharArray();
            prev='.';
            count=0;

            flag=false;
            for(char w:word) {
                if(isVowel(w)) flag=true;

                if(isVowel(w)!=isVowel(prev)) count=1;
                else count++; // 인접한 것이 둘 다 모음이거나 자음일 경우

                if(count>=3 || (prev==w && (w!='e' && w!='o'))) {
                    flag=false;
                    break;
                }

                prev=w;
            }

            if(flag) sb.append("<").append(password).append(acc);
            else sb.append("<").append(password).append(not);
        }
        System.out.println(sb);
    }

    static boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}