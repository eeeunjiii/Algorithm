import java.io.*;
import java.util.*;

public class Main {
    private static int N; // 정점 개수
    private static int M; // 간선 개수
    private static int R; // 시작 정점
    private static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
    private static boolean[] visited;
    private static int order=1; // 방문 순서
    private static int[] ans;
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        visited=new boolean[N+1]; // 1부터 시작
        ans=new int[N+1];
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());

            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }
        for(int i=1;i<graph.size();i++) {
            Collections.sort(graph.get(i));
        }
        dfs(R);

        for(int i=1;i<ans.length;i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int start) { // 시작 정점의 방문 순서는 1 (오름차순으로 방문), 방문하지 않는 경우에는 0 출력
        ans[start]=order;
        for(int v:graph.get(start)) {
            if(ans[v]==0) {
                order++;
                dfs(v);
            }
        }
    }
}