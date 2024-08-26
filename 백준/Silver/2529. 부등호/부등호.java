import java.io.*;
import java.util.*;

public class Main {

    static int K;
    static String[] c;
    static boolean[] visited;
    static int[] ans;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        K=Integer.parseInt(br.readLine());
        c=new String[K];
        visited=new boolean[10]; // 0~9
        ans=new int[K+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++) {
            c[i]=st.nextToken();
        }

        dfs(0, -1);

        List<String> result=new ArrayList<>();
        st=new StringTokenizer(sb.toString(), "\n");

        while(st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        System.out.println(result.get(result.size()-1)+"\n"+result.get(0));
    }

    private static void dfs(int depth, int cnt) {
        if(depth==K+1) {
            for(int v:ans) {
                sb.append(v);
            }
            sb.append("\n");
            return;
        }

        if(depth==0) {
            for(int i=0;i<=9;i++) {
                if(!visited[i]) {
                    visited[i]=true;
                    ans[depth]=i;
                    dfs(depth+1, cnt+1);
                    visited[i]=false;
                }
            }
        } else {
            for(int i=0;i<=9;i++) {
                if(!visited[i]) {
                    if(c[cnt].equals("<") && ans[depth-1]<i) {
                        visited[i]=true;
                        ans[depth]=i;
                        dfs(depth+1, cnt+1);
                        visited[i]=false;
                    }
                    if(c[cnt].equals(">") && ans[depth-1]>i){
                        visited[i]=true;
                        ans[depth]=i;
                        dfs(depth+1, cnt+1);
                        visited[i]=false;
                    }
                }
            }
        }
    }
}