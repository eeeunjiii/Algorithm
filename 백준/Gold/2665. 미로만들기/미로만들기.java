import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++) {
            String line=br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j]=line.charAt(j)-'0'; // 0: 검은 방, 1: 흰 방
            }
        }
        bfs(0,0,0);
    }

    static void bfs(int x, int y, int cnt) {
        PriorityQueue<Node> queue=new PriorityQueue<>();
        queue.offer(new Node(x, y, cnt));
        visited[x][y]=true;

        while(!queue.isEmpty()) {
            Node now=queue.poll();

            if(now.x==N-1 && now.y==N-1) {
                System.out.println(now.cnt);
                return;
            }

            for(int i=0;i<4;i++) {
                int nx=now.x+dx[i];
                int ny=now.y+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>= N) continue;
                if(!visited[nx][ny]) {
                    if(map[nx][ny]==0) {
                        visited[nx][ny]=true;
                        queue.offer(new Node(nx, ny, now.cnt+1));
                    } else if(map[nx][ny]==1) {
                        visited[nx][ny]=true;
                        queue.offer(new Node(nx, ny, now.cnt));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt-o.cnt;
        }
    }
}