import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 나무의 개수
        int C=Integer.parseInt(st.nextToken()); // 나무 자를 떄 드는 비용
        int W=Integer.parseInt(st.nextToken()); // 한 단위의 가격
        int[] trees=new int[N]; // 각 나무의 길이
        int max=Integer.MIN_VALUE;

        for (int i=0;i<N;i++) {
            trees[i]=Integer.parseInt(br.readLine());
            max=Math.max(max, trees[i]);
        }

        long maxSum=0;
        long price=0;

        for (int len=1;len<=max;len++) { // 통일시키고자 하는 나무 길이
            long sum=0;
            for (int i=0;i<N;i++) {
                long cnt;
                if (trees[i]>=len) {
                    if (trees[i]%len==0) {
                        cnt=(trees[i]/len)-1;
                    } else {
                        cnt=trees[i]/len;
                    }
                    price=((trees[i]/len)*len*W-(cnt*C));
                    if (price>0) sum+=price;
                }
            }
            maxSum=Math.max(sum, maxSum);
        }
        System.out.println(maxSum);
    }
}