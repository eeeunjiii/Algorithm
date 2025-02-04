import java.io.*;
import java.util.*;

public class Main {

    static int N, K, P, X;
    static int[][] num;
    static int ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 1~N층
        K=Integer.parseInt(st.nextToken()); // K 자리의 수
        P=Integer.parseInt(st.nextToken()); // 1~P개 반전 가능
        X=Integer.parseInt(st.nextToken()); // 현재 멈춰선 층 (현재의 층 번호)

        num=new int[10][7];
        num[0]=new int[] {1, 1, 1, 0, 1, 1, 1};
        num[1]=new int[] {0, 0, 1, 0, 0, 0, 1};
        num[2]=new int[] {0, 1, 1, 1, 1, 1, 0};
        num[3]=new int[] {0, 1, 1, 1, 0, 1, 1};
        num[4]=new int[] {1, 0, 1, 1, 0, 0, 1};
        num[5]=new int[] {1, 1, 0, 1, 0, 1, 1};
        num[6]=new int[] {1, 1, 0, 1, 1, 1, 1};
        num[7]=new int[] {0, 1, 1, 0, 0, 0, 1};
        num[8]=new int[] {1, 1, 1, 1, 1, 1, 1};
        num[9]=new int[] {1, 1, 1, 1, 0, 1, 1};

        int[] now=changeNumToArr(X);

        for(int i=1;i<=N;i++) {
            int[] next=changeNumToArr(i);
            checkEqualToNum(now, next);
        }

        System.out.println(ans);
    }

    static int[] changeNumToArr(int num) {
        int[] numArr=new int[K];
        int idx=K-1;
        while(num>0) {
            numArr[idx]=num%10;
            num/=10;
            idx--;
        }
        return numArr;
    }

    static void checkEqualToNum(int[] now, int[] next) {
        int sum=0;
        for(int i=0;i<now.length;i++) {
            sum+=countReverse(now[i], next[i]);
        }

        if(sum>=1 && sum<=P) ans++;
    }

    static int countReverse(int num1, int num2) {
        int cnt=0;
        for(int i=0;i<7;i++) {
            if(num[num1][i]!=num[num2][i]) cnt++;
        }
        return cnt;
    }
}