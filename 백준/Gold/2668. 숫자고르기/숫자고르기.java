import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] board;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        board=new int[N+1];
        visited=new boolean[N+1];
        list=new ArrayList<>();

        for(int i=1;i<=N;i++) {
            board[i]=Integer.parseInt(br.readLine());
        }

        for(int i=1;i<=N;i++) {
            visited[i]=true;
            dfs(i, i);
            visited[i]=false;
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int v:list) {
            System.out.println(v);
        }
    }

    static void dfs(int start, int num) {
        if(board[start]==num) {
            list.add(num);
        }
        if(!visited[board[start]]) {
            visited[board[start]]=true;
            dfs(board[start], num);
            visited[board[start]]=false;
        }
    }
}