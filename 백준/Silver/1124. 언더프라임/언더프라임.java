import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int cnt=0;
        
        for (int i=A;i<=B;i++) {
            if (underPrime(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    static boolean underPrime(int num) {
        int cnt=0;
        
        for (int i=2;i*i<=num;i++) {
            while (num%i==0) {
                cnt++;
                num/=i;
            }
        }
        if (num>1) {
            cnt++;
        }
        
        for (int i=2;i*i<=cnt;i++) { // 소수 판별을 두 번 해야 함.
            if (cnt%i==0) {
                return false;
            }
        }
        return cnt>1;
    } 
}