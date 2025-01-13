import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static char[] arr;
    static char[] ans;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        L=Integer.parseInt(st.nextToken()); // 문자열의 길이
        C=Integer.parseInt(st.nextToken()); // 주어진 알파벳의 개수
        arr=new char[C];
        ans=new char[L];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++) {
            arr[i]=st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        backtracking(0, 0);

        System.out.println(sb);
    }

    static void backtracking(int depth, int start) {
        if(depth==L) {
            if(check()) {
                for(char c:ans) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=start;i<C;i++) {
            ans[depth]=arr[i];
            backtracking(depth+1, i+1);
        }
    }

    static boolean check() {
        int vowel=0;
        int consonant=0;

        for(char c:ans) {
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if(vowel>=1 && consonant>=2) return true;
        else return false;
    }
}