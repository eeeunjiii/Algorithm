import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        dfs(N, 0);

        System.out.println(sb);
    }

    static void dfs(int depth, int num) {
        if(depth==0) {
            if(isPrime(num)) sb.append(num).append("\n");
            return;
        }
        for(int i=1;i<=9;i++) {
            int next=num*10+i;
            if(isPrime(next)) dfs(depth-1, next);
        }
    }

    static boolean isPrime(int num) {
        if(num<2) return false;

        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num%i==0) return false;
        }

        return true;
    }
}