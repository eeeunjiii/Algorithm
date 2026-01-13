import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());

        List<Integer> list=new ArrayList<>();
        list.add(A);
        // 수열을 계속 구하다 보면 반복수열이 나타남.
        // 반복되는 부분을 제외했을 때, 수열에 남게 되는 수의 개수
        // 얼마나 반복해야 하는지 구현하는 것이 중요할 것 같음

        StringBuilder sb=new StringBuilder();
        while (true) {
            int cur=list.get(list.size()-1);
            int next=0;

            while (cur!=0) {
                next+=(int) Math.pow(cur%10, (double) P);
                cur/=10;
            }

            if (list.contains(next)) {
                int ans=list.indexOf(next);
                sb.append(ans);
                break;
            }
            list.add(next);
        }
        System.out.println(sb);
    }
}