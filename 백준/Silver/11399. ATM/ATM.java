import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            P[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P); // 오름차순 정렬

        int sum=0;

        for(int i=1;i<=N;i++){
            sum+=P[i]*(N-i+1);
        }
        System.out.println(sum);
    }
}