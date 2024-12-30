import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int K=Integer.parseInt(br.readLine()); // 탐색해야 할, 정렬을 진행하는 사람의 수, N/K == 한 사람이 정렬해야 할 숫자의 개수

        // 사람 수: 8 -> 4-> 2 -> 1
        // 한 사람당 정렬해야 할 수의 개수: 2 -> 4 -> 8
        for(int i=0;i<N;i+=N/K) {
            sort(i, i+N/K);
        }

        System.out.println(sb);
    }
    private static void sort(int start, int end) {
        int[] temp=new int[end-start];
        for(int i=start;i<end;i++) {
            temp[i-start]=arr[i];
        }

        Arrays.sort(temp);

        for(int i=0;i<temp.length;i++) {
            sb.append(temp[i]).append(" ");
        }
    }

}