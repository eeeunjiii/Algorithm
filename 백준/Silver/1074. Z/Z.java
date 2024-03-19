import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static long cnt=0; // 0부터 count

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        // 0부터 시작
        int r = Integer.parseInt(st.nextToken());
        // 0부터 시작
        int c = Integer.parseInt(st.nextToken());

        divide(r, c, (int) Math.pow(2, N)); // 2^N

        System.out.println(cnt);
    }

    private static void divide(int r, int c, int size) {
        if(size==1) return;
        else if(r<size/2 && c<size/2) { // 1사분면에 있을 경우
            divide(r, c, size/2);
        } else if(r<size/2 && c>=size/2) { // 2사분면에 있을 경우
            cnt+=size*size/4;
            divide(r, c-size/2, size/2); // 2사분면에서의 상대위치
        } else if(r>=size/2 && c<size/2) {
            cnt+=(size*size/4)*2;
            divide(r-size/2, c, size/2); // 3사분면에서의 상대위치
        } else {
            cnt+=(size*size/4)*3;
            divide(r-size/2, c-size/2, size/2); // 4사분면에서의 상대위치
        }
    }
}