import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] num=new int[N];
        int[] arr=new int[N];

        Map<Integer, Integer> map=new HashMap<>();

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=num[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt=0;

        for(int i=0;i<N;i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], cnt);
                cnt++;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++) {
            sb.append(map.get(num[i])).append(" ");
        }

        System.out.println(sb);
    }
}