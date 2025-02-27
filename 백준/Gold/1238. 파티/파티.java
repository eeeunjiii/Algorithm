import java.io.*;
import java.util.*;

public class Main {

    static int N, M, X;
    static List<List<Node>> list, reverseList;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 학생 수
        M=Integer.parseInt(st.nextToken()); // 단방향 도로 개수
        X=Integer.parseInt(st.nextToken()); // 모이기로 한 마을 번호

        list=new ArrayList<>();
        reverseList=new ArrayList<>();
        for(int i=0;i<=N;i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int t=Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, t));
            reverseList.get(b).add(new Node(a, t));
        }

        int[] dist1=dijkstra(list);
        int[] dist2=dijkstra(reverseList);

        int ans=0;
        for(int i=0;i<=N;i++) {
            ans=Math.max(ans, dist1[i]+dist2[i]);
        }
        System.out.println(ans);
    }

    static int[] dijkstra(List<List<Node>> map) {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        int[] dist=new int[N+1];
        boolean[] visited=new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X]=0;

        while(!pq.isEmpty()) {
            int v=pq.poll().end;

            if(!visited[v]) visited[v]=true;
            else continue;

            for(Node next:map.get(v)) {
                if(dist[next.end]>dist[v]+next.time) {
                    dist[next.end]=dist[v]+next.time;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist;
    }
}
class Node implements Comparable<Node> {
    int end;
    int time;

    public Node(int end, int time) {
        this.end=end;
        this.time =time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time-o.time;
    }
}
