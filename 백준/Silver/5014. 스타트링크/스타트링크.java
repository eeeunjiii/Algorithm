import java.io.*;
import java.util.*;

public class Main {

    static int F; // 전체 층수
    static int S; // 현재 위치
    static int G; // 도착 위치
    static int U; // 위로 이동 가능한 층수
    static int D; // 아래로 이동 가능한 층수
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        F=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        U=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        visited=new boolean[F+1];

        int result=bfs();

        if(result<0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node(S, 0));
        visited[S]=true;

        while(!queue.isEmpty()) {
            Node now=queue.poll();

            if(now.idx==G) {
                return now.cnt;
            }
            if(now.idx+U<=F && !visited[now.idx+U]) {
                queue.offer(new Node(now.idx + U, now.cnt + 1));
                visited[now.idx+U]=true;
            }
            if(now.idx-D>0 && !visited[now.idx-D]) {
                queue.offer(new Node(now.idx - D, now.cnt + 1));
                visited[now.idx-D]=true;
            }
        }
        return -1;
    }

    static class Node {
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
