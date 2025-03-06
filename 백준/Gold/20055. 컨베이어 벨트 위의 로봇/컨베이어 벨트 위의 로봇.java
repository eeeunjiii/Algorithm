import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken()); // 내구도가 0인 칸이 K 이상인 경우 종료
        int[] arr=new int[2*N]; // 각 칸의 내구도
        boolean[] robot=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<2*N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        // 벨트는 로봇과 함께 한 칸 회전한다.
        // 올리는 위치와 내리는 위치는 무슨 상관인지 모르겠다.
        // 내구도는 로봇을 올리는 위치에 올리거나 이동하면 1씩 감소한다.

        int step=0;

        while(true) {
            step++;
            int temp=arr[N*2-1];
            for(int i=N*2-1;i>0;i--) { // 1단계: 한 칸 회전
                arr[i]=arr[i-1];
            }
            arr[0]=temp;

            for(int i=N-1;i>0;i--) {
                robot[i]=robot[i-1];
            }
            robot[0]=false;
            robot[N-1]=false;

            for(int i=N-1;i>0;i--) { // 2단계: 먼저 올라간 로봇부터 처리 -> N-1부터 시작
                if(robot[i-1] && !robot[i] && arr[i]>0) {
                    robot[i-1]=false;
                    robot[i]=true;
                    arr[i]--;
                    robot[N-1]=false;
                }
            }

            if(arr[0]>0) { // 3단계
                robot[0]=true;
                arr[0]--;
            }

            int cnt=0;
            for(int i=0;i<N*2;i++) {
                if(arr[i]==0) cnt++;
            }
            if(cnt>=K) break;
        }
        System.out.println(step);
    }
}