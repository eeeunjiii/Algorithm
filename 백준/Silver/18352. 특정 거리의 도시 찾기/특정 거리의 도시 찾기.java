import java.io.*;
import java.util.*;

public class Main {

    private static int N; // 도시의 개수 (노드)
    private static int M; // 도로의 개수 (링크)
    private static int K; // 거리 정보 (최단 거리)
    private static int X; // 출발 도시의 변호
    private static List<List<Integer>> graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());

        dist=new int[N+1];
        graph=new ArrayList<>(N+1);

        for(int i=0;i<N+1;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            graph.get(a).add(b); // 단방향
        }
        Arrays.fill(dist, -1);

        bfs();

        boolean check=false;
        for(int i=1;i<dist.length;i++) {
            if(dist[i]==K) {
                System.out.println(i);
                check=true;
            }
        }
        if (!check) System.out.println(-1);
//        System.out.println(Arrays.toString(dist));
    }

    private static void bfs() {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(X);
        dist[X]=0;

        while(!queue.isEmpty()) {
            int num=queue.poll();

            for(int val:graph.get(num)) {
                if(dist[val]==-1) {
                    dist[val]=dist[num]+1;
                    queue.offer(val);
                }
            }
        }
    }
}