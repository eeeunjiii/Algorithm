import java.io.*;
import java.util.*;
public class Main {
    private static int K;
    private static int[] S;
    private static int[] arr;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            sb=new StringBuilder();
            st=new StringTokenizer(br.readLine());
            K=Integer.parseInt(st.nextToken());

            if(K==0) return;
            else{
                S=new int[K];
                arr=new int[6];

                for(int i=0;i<K;i++){
                    S[i]=Integer.parseInt(st.nextToken());
                }
                dfs(0,0);

                System.out.println(sb);
            }
        }
    }
    private static void dfs(int start, int depth){
        if(depth==6){
            for(int val:arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<K;i++){
            arr[depth]=S[i];
            dfs(i+1, depth+1);
        }
    }
}