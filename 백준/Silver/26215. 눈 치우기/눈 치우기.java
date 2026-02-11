import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        Integer[] arr=new Integer[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int cnt=0;
        while (arr[0]>0) {
            if (arr.length>1) {
                if (arr[0]>0) arr[0]--;
                if (arr[1]>0) arr[1]--;
            } else {
                arr[0]--;
            }

            cnt++;

            Arrays.sort(arr, Collections.reverseOrder());
        }

        if (cnt>1440) System.out.println(-1);
        else System.out.println(cnt);
    }
}