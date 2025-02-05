import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());

        int cnt=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()>y) { // 높이가 낮아졌을 경우
                cnt++;
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek()==y) {
                continue;
            }
            stack.push(y);
        }
        while(!stack.isEmpty()) {
            if(stack.peek()>0) {
                cnt++;
            }
            stack.pop();
        }
        System.out.println(cnt);
    }
}