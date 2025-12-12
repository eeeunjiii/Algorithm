import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 스크린 크기
        int M=Integer.parseInt(st.nextToken()); // 바구니 크기
        int J=Integer.parseInt(br.readLine()); // 떨어지는 사과 개수

        int left=1;
        int right=M;
        int cnt=0;
        for (int i=0;i<J;i++) {
            int apple=Integer.parseInt(br.readLine());

            if (apple<left) {
                cnt+=left-apple;
                right-=left-apple;
                left=apple;
            } else if (right<apple) {
                cnt+=apple-right;
                left+=apple-right;
                right=apple;
            }
        }
        System.out.println(cnt);
    }
}