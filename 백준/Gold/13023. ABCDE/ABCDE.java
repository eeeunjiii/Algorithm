import java.io.*;
import java.util.*;

public class Main {
    private static int N; // 사람의 수
    private static int M; // 관계의 수
    private static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    private static boolean[] visited;
    private static int ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        visited=new boolean[N];

        for(int i=0;i<N;i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());

            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());

            list.get(num1).add(num2);
            list.get(num2).add(num1);
        }

        for(int i=0;i<N;i++) {
            if(ans==0) {
                Arrays.fill(visited, false);
                dfs(i, 0);
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int start, int depth) {
        if(depth==4){
            ans=1;
            return;
        }

        visited[start]=true;

        for(int i:list.get(start)) {
            if(!visited[i]) {
                visited[i]=true;
                dfs(i, depth+1);
            }
        }
        visited[start]=false;
    }
}