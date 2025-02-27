import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static int ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        S=br.readLine();
        String T=br.readLine();

        dfs(T);

        System.out.println(ans);
    }

    static void dfs(String t) {
        if(t.length()==S.length()) {
            if(t.equals(S)) ans=1;
            return;
        }

        if(t.endsWith("A")) {
            dfs(t.substring(0, t.length()-1));
        }
        if(t.startsWith("B")) {
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
}
