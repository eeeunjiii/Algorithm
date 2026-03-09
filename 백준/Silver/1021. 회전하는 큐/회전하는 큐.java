import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] num=new int[M];

        st=new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> queue=new LinkedList<>();
        for (int i=1;i<=N;i++) {
            queue.offer(i);
        }

        int count=0;
        for (int i=0;i<M;i++) {
            int targetIdx=queue.indexOf(num[i]);
            int halfIdx;

            if (queue.size()%2==0) {
                halfIdx=queue.size()/2-1;
            } else {
                halfIdx=queue.size()/2;
            }

            if (targetIdx<=halfIdx) {
                // 왼쪽으로 이동
                for (int j=0;j<targetIdx;j++) {
                    int v=queue.pollFirst();
                    queue.offerLast(v);
                    count++;
                }
            } else {
                // 오른쪽으로 이동
                for (int j=0;j<queue.size()-targetIdx;j++) {
                    int v=queue.pollLast();
                    queue.offerFirst(v);
                    count++;
                }
            }

            queue.pollFirst();
        }
        System.out.println(count);
    }
}