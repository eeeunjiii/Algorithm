import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        Integer[] arr=new Integer[N];

        for (int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬

        int answer=-1;
        for (int i=0;i<N;i++) {
            int cur=arr[i];

            for (int j=i+1;j<N-1;j++) {
                if (cur<arr[j]+arr[j+1]) {
                    answer=cur+arr[j]+arr[j+1];
                    break;
                }
            }

            if (answer!=-1) {
                break;
            }
        }
        System.out.println(answer);
    }
}