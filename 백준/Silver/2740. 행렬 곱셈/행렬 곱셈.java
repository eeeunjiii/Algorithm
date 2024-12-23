import java.io.*;
import java.util.*;

public class Main {

    private static final int threshold=70;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] arr1=new int[128][128];

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr1[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[][] arr2=new int[128][128];

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++) {
                arr2[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int pow=Math.max(Math.max(N, K), M);
        int size=1;

        while(true) { // 2^n을 만족하는 n 값을 찾는 과정
            if(size>=pow) break;
            size*=2;
        }

        int[][] ans=new int[N][K];
        ans=multiply(arr1, arr2, size);

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<N;i++) {
            for(int j=0;j<K;j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int[][] multiply(int[][] A, int[][] B, int size) {
        int[][] ans=new int[size][size];
        if(size<=threshold) {
            return loopMultiply(A, B, size);
        }

        int halfSize=size/2;

        int[][] a11=subArray(A, 0,0, halfSize);
        int[][] a12=subArray(A, 0,halfSize, halfSize);
        int[][] a21=subArray(A, halfSize,0, halfSize);
        int[][] a22=subArray(A, halfSize,halfSize, halfSize);

        int[][] b11=subArray(B, 0,0, halfSize);
        int[][] b12=subArray(B, 0,halfSize, halfSize);
        int[][] b21=subArray(B, halfSize,0, halfSize);
        int[][] b22=subArray(B, halfSize,halfSize, halfSize);

        int[][] M1=multiply(add(a11, a22, halfSize), add(b11, b22, halfSize), halfSize);
        int[][] M2=multiply(add(a21, a22, halfSize), b11, halfSize);
        int[][] M3=multiply(a11, sub(b12, b22, halfSize), halfSize);
        int[][] M4=multiply(a22, sub(b21, b11, halfSize), halfSize);
        int[][] M5=multiply(add(a11, a12, halfSize), b22, halfSize);
        int[][] M6=multiply(sub(a21, a11, halfSize), add(b11, b12, halfSize), halfSize);
        int[][] M7=multiply(sub(a12, a22, halfSize),add(b21, b22, halfSize), halfSize);

        int[][] c11=add(sub(add(M1, M4, halfSize), M5, halfSize), M7, halfSize);
        int[][] c12=add(M3, M5, halfSize);
        int[][] c21=add(M2, M4, halfSize);
        int[][] c22=add(add(sub(M1, M2, halfSize), M3, halfSize), M6, halfSize);

        merge(c11, ans, 0,0, halfSize);
        merge(c12, ans, 0, halfSize, halfSize);
        merge(c21, ans, halfSize, 0, halfSize);
        merge(c22, ans, halfSize, halfSize, halfSize);

        return ans;
    }

    public static int[][] loopMultiply(int[][] A, int[][] B, int size) {
        int[][] ans=new int[size][size];
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                for(int l=0;l<size;l++) {
                    ans[i][j]+=A[i][l]*B[l][j];
                }
            }
        }
        return ans;
    }

    public static int[][] subArray(int[][] src, int row, int col, int size) {
        int[][] subArr=new int[size][size];
        for(int dest_i=0, src_i=row;dest_i<size;dest_i++, src_i++) {
            for(int dest_j=0, src_j=col;dest_j<size;dest_j++, src_j++) {
                subArr[dest_i][dest_j]=src[src_i][src_j];
            }
        }
        return subArr;
    }

    public static int[][] sub(int[][] A, int[][] B, int size) {
        int[][] ans=new int[size][size];

        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                ans[i][j]=A[i][j]-B[i][j];
            }
        }
        return ans;
    }

    public static int[][] add(int[][] A, int[][] B, int size) {
        int[][] ans=new int[size][size];

        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                ans[i][j]=A[i][j]+B[i][j];
            }
        }
        return ans;
    }

    public static void merge(int[][] src, int[][] dest, int row, int col, int size) {
        for(int src_i=0, dest_i=row;src_i<size;src_i++, dest_i++) {
            for(int src_j=0, dest_j=col;src_j<size;src_j++, dest_j++) {
                dest[dest_i][dest_j]=src[src_i][src_j];
            }
        }
    }

}