import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
//        StringTokenizer st=new StringTokenizer(br.readLine());

        int T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            sb.append(solve(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    private static String solve(String line) {
        Stack<Character> stack=new Stack<>();

        for(int j=0;j<line.length();j++) {
            char ch=line.charAt(j);

            if(ch=='(') {
                stack.push(ch);
            } else if(stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if(stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}