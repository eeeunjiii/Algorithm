import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        while(N>0) {
            if(N%5==0){
                N-=5;
                cnt++;
            } else if(N%3==0){
                N-=3;
                cnt++;
            } else{
                N-=5;
                cnt++;
            }
        }
        if(N!=0) cnt=-1;
        
        System.out.println(cnt);
    }
}