import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] switches=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
          switches[i]=Integer.parseInt(st.nextToken());
        }

        int S=Integer.parseInt(br.readLine()); // 학생 수

        for(int i=0;i<S;i++) {
            st=new StringTokenizer(br.readLine());
            int gender=Integer.parseInt(st.nextToken());
            int number=Integer.parseInt(st.nextToken());

            if (gender==1) { // 남학생인 경우
                for(int j=number;j<=N;j+=number) {
                    switches[j]=(switches[j]==0 ? 1:0);
                }
            } else { // 여학생인 경우
                int l=number;
                int r=number;

                while((l-1>=1 && r+1<=N) && switches[l-1]==switches[r+1]) {
                    l--;
                    r++;
                }

                for(int j=l;j<=r;j++) {
                    switches[j]=(switches[j]==0 ? 1:0);
                }
            }
        }

        for(int j=1;j<=N;j++) {
            System.out.print(switches[j]+" ");
            if(j%20==0) {
                System.out.println();
            }
        }
    }
}