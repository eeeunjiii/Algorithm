import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        int[][] line=new int[N][2];
        int[] dp=new int[N];

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            line[i][0]=Integer.parseInt(st.nextToken()); // A
            line[i][1]=Integer.parseInt(st.nextToken()); // B
        }

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for(int i=0;i<N;i++) {
            dp[i]=1; // i번째에 연결된 것으로 간주

            for(int j=0;j<i;j++) {
                if(line[i][1]>line[j][1]) {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max=0;
        for(int i=0;i<N;i++) {
            max=Math.max(max, dp[i]);
        }
        System.out.println(N-max);
    }
}