import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int TC=Integer.parseInt(br.readLine());

        while(TC-->0) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken()); // 문서의 개수
            int M=Integer.parseInt(st.nextToken()); // 인쇄 순서를 구하고자 하는 문서가 Queue에 위치 번호
            int[] priority=new int[N];

            PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });
            Queue<int[]> queue=new LinkedList<>();

            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                priority[i]=Integer.parseInt(st.nextToken());
                pq.offer(new int[]{i, priority[i]});
                queue.offer(new int[]{i, priority[i]});
            }

            int cnt=1;
            while(true) {
                if(pq.peek()[1]==queue.peek()[1]) {
                    if(queue.peek()[0]==M) break;
                    else {
                        queue.poll();
                        pq.poll();
                        cnt++;
                    }
                } else {
                    queue.offer(queue.poll());
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}