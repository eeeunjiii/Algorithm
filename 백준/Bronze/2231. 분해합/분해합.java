import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(br.readLine());
        System.out.println(findConstructNum(N));
    }

    private static int findConstructNum(int num) {
        for(int i=1;i<=num;i++) { // 9969
            int temp=i;
            int sum=i;

            while(temp!=0) {
                sum+=temp%10;
                temp/=10;
            }
            if(sum==num) return i;
        }
        return 0;
    }
}