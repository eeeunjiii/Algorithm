import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();

        String line=br.readLine();
        int len=line.length();

        boolean flag=false; // 태그가 있는지 확인
        for(int i=0;i<len;i++) {
            if(line.charAt(i)=='<') {
                flag=true;
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(line.charAt(i));
            } else if(line.charAt(i)=='>') {
                flag=false;
                sb.append(line.charAt(i));
            } else if(flag) {
                sb.append(line.charAt(i));
            } else if(!flag) {
                if(line.charAt(i)==' ') { // 하나의 단어가 끝났을 경우
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(line.charAt(i));
                } else {
                    stack.push(line.charAt(i));
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}