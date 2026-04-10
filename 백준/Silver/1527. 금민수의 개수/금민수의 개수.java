import java.io.*;
import java.util.*;

public class Main {

    static int A, B;
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());

        dfs(0L);

        System.out.println(cnt);
    }

    static void dfs(long num) {
        if (num>B) {
            return;
        }

        if (num>=A) {
            cnt++;
        }
        dfs(10*num+4);
        dfs(10*num+7);
    }
}