import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];

        StringTokenizer st;
        for (int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if (N%2==1) System.out.println(1);
        else System.out.println(Math.abs(arr[N/2]-arr[N/2-1]+1)); // arr[N/2] ~ arr[N/2-1]까지이므로 양쪽 포함하기 위해 +1
    }
}