import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 과일의 개수
        int L=Integer.parseInt(st.nextToken()); // 초기 길이 -> 하나씩 증가

        int[] height=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<height.length;i++) {
            height[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(height);

        for (int j : height) {
            if (L >= j) {
                L++;
            }
        }
        System.out.println(L);
    }
}
