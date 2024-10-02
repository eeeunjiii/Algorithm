import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        Queue<Integer> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();

        int cnt=1;
        for(int i=1;i<=N;i++) {
            queue.offer(i);
        }

        while(!queue.isEmpty()) {
            if(cnt==K) {
                list.add(queue.poll());
                cnt=1;
            } else {
                queue.add(queue.poll());
                cnt++;
            }
        }

        StringBuilder sb=new StringBuilder();
        sb.append("<");

        for(int i=0;i<list.size();i++) {
            if(i==list.size()-1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i)).append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}