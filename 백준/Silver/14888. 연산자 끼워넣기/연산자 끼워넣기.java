import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] num;
    private static final int[] cal=new int[4]; // + - * /
    private static int maxValue=Integer.MIN_VALUE;
    private static int minValue=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        num=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++){
            cal[i]=Integer.parseInt(st.nextToken());
        }
        dfs(num[0], 1);

        System.out.println(maxValue+"\n"+minValue);
    }
    private static void dfs(int temp, int idx){
        if(idx==N){
            maxValue=Math.max(maxValue, temp);
            minValue=Math.min(minValue, temp);
            return;
        }

        for(int i=0;i<4;i++){
            if(cal[i]>0){
                cal[i]--;

                switch (i){
                    case 0: dfs(temp+num[idx], idx+1); break;
                    case 1: dfs(temp-num[idx], idx+1); break;
                    case 2: dfs(temp*num[idx], idx+1); break;
                    case 3: dfs(temp/num[idx], idx+1); break;
                }
                cal[i]++;
            }
        }

    }
}