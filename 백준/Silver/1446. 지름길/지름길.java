import java.io.*;
import java.util.*;

class Node {
    int end;
    int len;

    public Node(int end, int len) {
        this.end = end;
        this.len = len;
    }
}

public class Main {

    private static int N; // 지름길의 개수, 간선의 개수
    private static int D; // 고속도로의 길이
    private static List<List<Node>> graph=new ArrayList<>();
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        dist=new int[10001];

        for(int i=0;i<dist.length;i++) {
            dist[i]=i;
        }

        for(int i=0;i<=10001;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());

            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int len=Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, len));
        }
        dijkstra(0);
        System.out.println(dist[D]);
    }

    private static void dijkstra(int start) {
        if(start>D) return;

        if(dist[start+1]>dist[start]+1) dist[start+1]=dist[start]+1;

        for(int i=0;i<graph.get(start).size();i++) {
            Node next=graph.get(start).get(i);

            if(dist[next.end]>dist[start]+next.len) {
                dist[next.end]=dist[start]+next.len;
            }
        }
        dijkstra(start+1);
    }
}
