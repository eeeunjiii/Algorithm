import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());

        // (1, 1) 루트에서 시작
        int leftCnt=0;
        int rightCnt=0;

        while (A!=1 || B!=1) {
            if (A<B) {
                B-=A;
                rightCnt++;
            } else {
                A-=B;
                leftCnt++;
            }
        }
        System.out.println(leftCnt+" "+rightCnt);
    }
}