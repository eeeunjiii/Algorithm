import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int ans = findNum(N);
        System.out.println(ans);
    }

    private static int findNum(int num) {
        int cnt=0;

        if(num<=99) return num;
        else {
            cnt=99;

            for(int i=100;i<=num;i++) {
                int num1=i/100; // 백의 자릿수
                int num2=(i/10)%10; // 십의 자릿수
                int num3=i%10; // 일의 자릿수

                if(num1-num2 == num2-num3) cnt++;
            }
        }
        return cnt;
    }
}