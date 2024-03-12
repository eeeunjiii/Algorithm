import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
//        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(br.readLine());
        arr=new int[N];

        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++) {
            if(arr[i]!=0) {
                pq.offer(arr[i]);
            } else {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    Integer v = pq.poll();
                    sb.append(v).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}