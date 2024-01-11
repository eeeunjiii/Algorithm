import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr; // 인덱스: 열, 값: 행
    private static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N+1];

        dfs(0);
        System.out.println(cnt);
    }
    private static void dfs(int depth){
        if(depth == N){
            cnt++;
            return ;
        }
        for(int i=0;i<N;i++){
            arr[depth]=i;
            if(check(depth)){
                dfs(depth+1);
            }
        }
    }
    private static boolean check(int col){
        for(int i=0;i<col;i++){ // 이전에 놓은 체스 말들과 위치 비교
            if(arr[col]==arr[i]) return false; // 같은 행에 놓이는 경우 (열이 동일한 경우는 자연스럽게 제외; col-1까지 반복)
            if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])) return false; // 같은 선상의 대각선에 놓이는 경우
        }
        return true;
    }
}