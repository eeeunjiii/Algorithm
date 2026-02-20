import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        Integer[] arr=new Integer[N]; // 각 나무가 다 자라는 데 며칠이 걸리는지

        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i=0;i<N;i++) {
            arr[i]+=i;
        }
        Arrays.sort(arr);

        System.out.println(arr[N-1]+2);
    }
}