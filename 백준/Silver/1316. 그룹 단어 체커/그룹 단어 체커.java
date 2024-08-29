import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        int ans=0;

        for(int i=0;i<N;i++) {
            if(check()) ans++; // 그룹 문자를 만족하면 ans 증가
        }
        System.out.println(ans);
    }

    private static boolean check() throws IOException {
        boolean[] visited=new boolean[26];
        int prev=0; // 이전 알파벳
        String str=br.readLine();

        for(int i=0;i<str.length();i++) {
            int cur=str.charAt(i);

            if(prev!=cur) { // 이전과 현재 알파벳이 다른 경우
                if(!visited[cur-'a']) { // 한 번도 방문하지 않은 알파벳이라면 (처음 나온 알파벳)
                    visited[cur-'a']=true;
                    prev=cur;
                } else { // 이전에 나온 알파벳인 경우 (그룹 문자가 아님)
                    return false;
                }
            }
        }
        return true;
    }
}