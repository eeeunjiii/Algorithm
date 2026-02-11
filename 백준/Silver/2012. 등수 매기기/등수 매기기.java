import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N+1]; // 각 사람의 예상 등수

        for (int i=1;i<=N;i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long ans=0;
        for (int i=1;i<=N;i++) {
            ans+=Math.abs(arr[i]-i);
        }
        System.out.println(ans);
    }
}