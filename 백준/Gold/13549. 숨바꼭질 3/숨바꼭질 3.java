import java.io.*;
import java.util.*;

public class Main {

    private static int N; // 수빈
    private static int K; // 동생
    private static boolean[] visited;
    private static int max=100_000;
    private static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        visited=new boolean[max+1];

        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node(N, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.idx]=true;

            if(node.idx==K) min=Math.min(node.time, min);

            if (node.idx * 2 <= max && !visited[node.idx*2]) queue.offer(new Node(node.idx*2, node.time));
            if (node.idx + 1 <= max && !visited[node.idx+1]) queue.offer(new Node(node.idx+1, node.time+1));
            if (node.idx - 1 >=0 && !visited[node.idx-1]) queue.offer(new Node(node.idx-1, node.time+1));
        }
    }

    private static class Node {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}