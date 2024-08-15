import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int T=Integer.parseInt(st.nextToken()); // 자두가 떨어지는 시간
        int W=Integer.parseInt(st.nextToken()); // 최대 움직임
        int now=1; // 1번 나무 아래에 있음(현재 자두의 위치)

        int[][] dp=new int[T+1][W+1];

        int[] arr=new int[T+1];
        for(int i=1;i<=T;i++) {
            arr[i]=Integer.parseInt(br.readLine()); // (1) 2 1 1 2 2 1 1
        }

        int answer=0;
        for(int i=1;i<=T;i++) {
            int tree=arr[i];

            for(int j=0;j<=W;j++) {
                if(j==0) { // 이동을 하지 않았을 때, j==0
                    now=1;
                    if(tree==now) {
                        dp[i][j]=dp[i-1][j]+1;
                    } else {
                        dp[i][j]=dp[i-1][j];
                    }
                } else { // 이동했을 때
                    if(j%2==0) { // 1번 나무로
                        now=1;

                        if(tree==now) { // 현재 위치와 동일한 경우
                            dp[i][j]=Math.max(dp[i-1][j]+1, dp[i-1][j-1]); // j에 변화가 없으면 이동X, 따라서 이전에 이동해서 온 경우와 이동하지 않은 경우를 비교
                        } else { // 현재 위치와 나무의 위치가 다른 경우
                            dp[i][j]=Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                        }
                    } else { // 2번 나무로
                        now=2;

                        if(tree==now) { // 현재 위치와 동일한 경우
                            dp[i][j]=Math.max(dp[i-1][j]+1, dp[i-1][j-1]);
                        } else { // 현재 위치와 나무의 위치가 다른 경우
                            dp[i][j]=Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                        }
                    }
                }
                answer=Math.max(answer, dp[T][W]);
            }
        }
        System.out.println(answer);
    }
}