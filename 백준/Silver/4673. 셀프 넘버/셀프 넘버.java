import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        boolean[] visited=new boolean[10001];

        for(int i=1;i<=10_000;i++) {
            int num=d(i);

            if(num<10001) {
                visited[num]=true; // 해당 연산으로 생성된 숫자들
            }
        }

        StringBuilder sb=new StringBuilder();

        for(int i=1;i<=10_000;i++) {
            if(!visited[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int d(int num) {
        int sum=num;

        while(num!=0) {
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}