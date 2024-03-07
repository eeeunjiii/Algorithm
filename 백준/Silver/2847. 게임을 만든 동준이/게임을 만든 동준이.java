import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(br.readLine());
        int[] level=new int[N+1]; // 0~N

        for(int i=1;i<level.length;i++) {
            level[i]=Integer.parseInt(br.readLine());
        }

        int cnt=0;

        for(int i=level.length-1;i>0;i--) {
            if(level[i]<=level[i-1]) {
                int num = Math.abs(level[i] - level[i - 1]);
                cnt+= num +1;
                level[i-1]-= num +1;
            }
        }
        System.out.println(cnt);
    }
}