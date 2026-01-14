import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        List<Integer> list=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 1. 첫 번째, 마지막을 제외한 구슬 중 하나를 고르고 번호를 x라고 함.
        // 2. x번째 구슬 제거
        // 3. W(x-1) * W(x+1) 에너지 획득 가능
        // 4. N-- -> 번호를 다시 매기기
        // 모을 수 있는 에너지의 최댓값

        dfs(list, 0);
        System.out.println(max);
    }

    static void dfs (List<Integer> list, int sum) {
        if (list.size()==2) {
            max=Math.max(max, sum);
            return;
        }

        for (int i=1;i<list.size()-1;i++) {
            int v=list.get(i);
            int calValue=list.get(i-1)*list.get(i+1);
            list.remove(i);
            dfs(list, sum+calValue);
            list.add(i, v); // 이 부분을 구현하지 않음
        }
    }
}