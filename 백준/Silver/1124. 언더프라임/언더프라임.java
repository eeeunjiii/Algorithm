import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int[] dp=new int[B+1];

        dp[2]=1; // 소수로만 이루어진 인수 개수
        dp[3]=1;

        for (int i=4;i<=B;i++) {
            if (isPrime(i)) { // 소수인 경우
                dp[i]=1;
            } else {
                for (int j=2;j<i;j++) {
                    if (i%j==0) {
                        dp[i]=dp[j]+dp[i/j];
                        break;
                    }
                }
            }
        }

        int cnt=0;
        for (int i=A;i<=B;i++) {
            if (isPrime(dp[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);

        // 자연수 X를 소인수분해하면, 곱해서 X가 되는 소수의 목록
        // 어떤 수 X를 소인분해 해서 구한 소수의 목록의 길이가 소수이면 -> 언더프라임
        // A와 B 사이의 정수 중에서 언더프라임인 것의 개수

    }

    static boolean isPrime(int num) {
        if (num<2) {
            return false;
        }

        if (num==2) {
            return true;
        }

        for (int i=2;i<num;i++) {
            if (num%i==0) {
                return false;
            }
        }
        return true;
    }
}