import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int K=Integer.parseInt(br.readLine()); // 1m^2에 자라는 참외의 개수

        int maxH=0;
        int maxW=0;
        int maxHIdx=-1;
        int maxWIdx=-1;

        int[] dir=new int[6];
        int[] dist=new int[6];

        StringTokenizer st;
        for (int i=0;i<6;i++) {
            st=new StringTokenizer(br.readLine());
            dir[i]=Integer.parseInt(st.nextToken());
            dist[i]=Integer.parseInt(st.nextToken());

            if (dir[i]==1 || dir[i]==2) { // 가로 방향인 경우
                if (maxH<dist[i]) {
                    maxH=dist[i];
                    maxHIdx=i;
                }
            } else { // 세로 방향인 경우
                if (maxW<dist[i]) {
                    maxW=dist[i];
                    maxWIdx=i;
                }
            }
        }

        int maxExtent=maxW*maxH;
        int minExtent=dist[(maxWIdx+3)%6]*dist[(maxHIdx+3)%6];

        System.out.println(K*(maxExtent-minExtent));
    }
}