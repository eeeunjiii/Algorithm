import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] number={1, 5, 10, 50};
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        list=new ArrayList<>();

        // I: 1, V: 5, X: 10, L:50
        // 순서 무관 (순서 달라도 같은 것으로 취급)
        dfs(0, 0, 0);

        System.out.println(list.size());
    }

    static void dfs(int depth, int start, int sum) {
        if (depth==N) {
            if (!list.contains(sum)) {
                list.add(sum);
            }
            return;
        }

        for (int i=start;i<4;i++) {
            dfs(depth+1, i, sum+number[i]);
        }
    }
}