import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        String num=br.readLine();

        int[] arr=new int[N];

        for(int i=0;i<N;i++) {
            int n = Character.getNumericValue(num.charAt(i));
            arr[i]=n;
        }

        int cnt=0;
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<N;i++) {
            while(!stack.isEmpty() && stack.peek()<arr[i] && cnt<K) {
                stack.pop();
                cnt++;
            }
            stack.push(arr[i]);
        }

        while(cnt<K) {
            stack.pop();
            cnt++;
        }
        for(int val:stack) {
            sb.append(val);
        }
        System.out.println(sb);
    }
}
