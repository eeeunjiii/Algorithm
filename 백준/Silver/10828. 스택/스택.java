import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            String commit=st.nextToken();

            if(commit.equals("push")) {
                int num=Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if(commit.equals("pop")){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            } else if(commit.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if(commit.equals("empty")) {
                if(!stack.isEmpty()) sb.append(0).append("\n");
                else sb.append(1).append("\n");
            } else if(commit.equals("top")) {
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}