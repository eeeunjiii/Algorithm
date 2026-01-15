import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] card;
    static boolean[] visited;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        K=Integer.parseInt(br.readLine());
        card=new int[N];
        visited=new boolean[N];

        for (int i=0;i<N;i++) {
            card[i]=Integer.parseInt(br.readLine());
        }
        list=new ArrayList<>();

        dfs(0, "");

        System.out.println(list.size());
    }

    static void dfs(int depth, String temp) {
        if (depth==K) {
            if (!list.contains(temp)) {
                list.add(temp);
            }
            return;
        }

        for (int i=0;i<N;i++) {
            if (!visited[i]) {
                visited[i]=true;
                dfs(depth+1, temp+card[i]);
                visited[i]=false;
            }
        }
    }
}