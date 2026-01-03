import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String line=br.readLine();
        line=line.toUpperCase();

        int[] alphabet=new int[26]; // 대문자로 변환해서 판별
        for (int i=0;i<line.length();i++) {
            char ch=line.charAt(i);
            alphabet[ch-'A']++;
        }

        char ans='?';
        int max=-1;

        for (int i=0;i<26;i++) {
            if (alphabet[i]>max) {
                max=alphabet[i];
                ans=(char) (i+65);
            } else if(alphabet[i]==max) {
                ans='?';
            }
        }
        System.out.println(ans);
    }
}