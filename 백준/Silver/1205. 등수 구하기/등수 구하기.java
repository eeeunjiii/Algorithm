import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 리스트에 있는 점수의 개수
        int score=Integer.parseInt(st.nextToken()); // 태수의 새로운 점수
        int P=Integer.parseInt(st.nextToken()); // 랭킹 리스트에 올라갈 수 있는 점수의 개수

        if(N!=0) {
            int[] arr=new int[N];

            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }

            if(N==P && score<=arr[N-1]) {
                System.out.println(-1);
            } else {
                int rank=1;
                for(int i=0;i<N;i++) {
                    if(score<arr[i]) rank++;
                    else break;
                }
                System.out.println(rank);
            }
        } else System.out.println(1);
    }
}