import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 전체 길이
        int K=Integer.parseInt(st.nextToken()); // 가능한 간격: K 이하에 있는 햄버거를 먹을 수 있음

        String line=br.readLine();
        char[] table=line.toCharArray();
        boolean[] visited=new boolean[N];

        // 햄버거를 먹을 수 있는 최대 사람 수 출력
        // 양쪽에 먹을 수 있는 햄버거가 있는 경우, 왼쪽 오른쪽의 차이가 있을 것 같음

        int cnt=0;
        for(int i=0;i<N;i++) {
            if(table[i]=='P') {
                for(int k=-K;k<=K;k++) {
                    if(i+k>=N) break;
                    if(i+k<0) continue;

                    if(table[i+k]=='H' && !visited[i+k]) {
                        visited[i+k]=true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}