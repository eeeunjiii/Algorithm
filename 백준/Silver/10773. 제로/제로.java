import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack=new Stack<>();

        int K=Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++) {
            int num=Integer.parseInt(br.readLine());
            if(num!=0) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }

        int sum=0;
        while(!stack.isEmpty()) {
            sum+=stack.pop();
        }
        System.out.println(sum);
    }
}