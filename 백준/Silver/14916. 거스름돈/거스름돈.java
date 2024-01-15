import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int cnt=0;

        while(N>0){
            if(N%5==0){
                N-=5;
                cnt++;
            } else if(N%2==0){
                N-=2;
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