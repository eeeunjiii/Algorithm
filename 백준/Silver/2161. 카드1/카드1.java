import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());

        // 1번 카드가 제일 위에, N번 카드가 제일 아래에 놓여 있음
        // 카드가 한 장 남을 때까지 아래 과정을 반복

        // 1. 제일 위에 있는 카드를 바닥에 버림
        // 2. 그 다음 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김.
        // 1 2 3 4 -> 3 4 2 -> ... 마지막에 남게 되는 카드 출력
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=N;i++) {
            queue.offer(i);
        }

        while(queue.size()!=1) {
            sb.append(queue.poll()).append(" ");
            int v=queue.poll();

            queue.offer(v);
        }
        sb.append(queue.peek());

        System.out.println(sb);
    }
}