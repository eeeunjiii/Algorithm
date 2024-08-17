import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]> chicken=new ArrayList<>();
    static List<int[]> home=new ArrayList<>();
    static List<int[]> ans=new ArrayList<>();
    static boolean[] visited;
    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken()); // 최대 치킨집 개수

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int num=Integer.parseInt(st.nextToken());
                if(num==1) home.add(new int[]{i, j});
                else if(num==2) chicken.add(new int[]{i, j});
            }
        }
        visited=new boolean[chicken.size()];

        dfs(0,0);
        System.out.println(result);
    }

    static void dfs(int depth, int start) {
        if(depth==M) {
            int sum=0;
            for(int[] h:home) {
                int min=Integer.MAX_VALUE;
                for(int[] a:ans) {
                    int dist=Math.abs(h[0]-a[0])+Math.abs(h[1]-a[1]);
                    min=Math.min(min, dist);
                }
                sum+=min;
            }
            result=Math.min(result, sum);
            return;
        }

        for(int i=start;i<chicken.size();i++) { // (1,2), (2,1)와 같은 경우는 중복으로 처리해야 하기 때문에
            ans.add(chicken.get(i));
            dfs(depth+1, i+1);
            ans.remove(ans.size()-1);
        }
    }
}