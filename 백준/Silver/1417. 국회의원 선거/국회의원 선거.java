import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int num=Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N-1;i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt=0;
        while(!pq.isEmpty() && pq.peek()>=num) {
            num++;
            pq.add(pq.poll()-1);
            cnt++;
        }
        System.out.println(cnt);
    }
}