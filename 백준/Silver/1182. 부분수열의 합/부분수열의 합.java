import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int S;
    private static int[] arr;
    private static int cnt=0;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());

        arr=new int[N];

        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        
        if(S==0) System.out.println(cnt-1);
        else System.out.println(cnt);
    }
    private static void dfs(int depth, int sum){
        if(depth==N){
            if(sum==S){
                cnt++;
            }
            return;
        }
        dfs(depth+1, sum+arr[depth]);
        dfs(depth+1, sum);
    }
}