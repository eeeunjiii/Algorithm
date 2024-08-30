import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());

        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            String commit=st.nextToken();

            if(commit.equals("push_front")) {
                int num=Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if(commit.equals("push_back")) {
                int num=Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if(commit.equals("pop_front")) {
                if(deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.removeFirst()).append("\n");
            } else if(commit.equals("pop_back")) {
                if(deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.removeLast()).append("\n");
            } else if(commit.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if(commit.equals("empty")) {
                if(deque.isEmpty()) sb.append(1).append("\n");
                else  sb.append(0).append("\n");
            } else if(commit.equals("front")) {
                if(deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.getFirst()).append("\n");
            } else if(commit.equals("back")) {
                if(deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.getLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}