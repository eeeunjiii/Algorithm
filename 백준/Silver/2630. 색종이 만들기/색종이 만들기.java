import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[][] paper;
    private static int[] cntPaper=new int[2]; // 0 -> 하얀색, 1 -> 파란색

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        paper=new int[N+1][N+1];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                paper[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        System.out.println(cntPaper[0]+"\n"+cntPaper[1]);
    }
    private static boolean check(int value, int x, int y, int size){
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(paper[i][j]!=value) return false;
            }
        }
        return true;
    }
    private static void divide(int x, int y, int size){
        if(check(paper[x][y], x, y, size)){ // 압축이 가능한 경우 -> 분할할 필요가 없음
            if(paper[x][y]==0) cntPaper[0]++;
            else cntPaper[1]++;
            return ;
        }

        divide(x, y, size/2);
        divide(x+size/2, y, size/2);
        divide(x, y+size/2, size/2);
        divide(x+size/2, y+size/2, size/2);
    }
}