import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        String first=br.readLine();
        int result=0;

        for(int i=0;i<N-1;i++) {
            String word=br.readLine();
            int cnt=0;
            int[] alphabet=new int[26];
            for(int j=0;j<first.length();j++) {
                alphabet[first.charAt(j)-'A']++;
            }

            for(int j=0;j<word.length();j++) {
                if(alphabet[word.charAt(j)-'A']>0) {
                    cnt++; // first와 word가 동일하게 갖고 있는 알파벳 종류의 개수
                    alphabet[word.charAt(j)-'A']--;
                }
            }

            if(first.length()==word.length() && (word.length()==cnt || word.length()-1==cnt)) {
                result++;
            } else if(first.length()==word.length()-1 && word.length()-1==cnt) { // word에서 제거했을 때 동일해지는 경우
                result++;
            } else if(first.length()==word.length()+1 && word.length()==cnt) { // word에 추가했을 때 동일해지는 경우
                result++;
            }
        }
        System.out.println(result);
    }
}