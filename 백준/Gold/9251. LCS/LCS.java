import java.io.*;
import java.util.*;
public class Main {
    private static char[] arr1;
    private static char[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        arr1=br.readLine().toCharArray();
        arr2=br.readLine().toCharArray();

        int[][] lcs=new int[arr1.length+1][arr2.length+1];

        for(int i=1;i<=arr1.length;i++){
            for(int j=1;j<=arr2.length;j++){
                if(arr1[i-1]!=arr2[j-1]) {
                    lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
                } else{
                    lcs[i][j]=lcs[i-1][j-1]+1;
                }
            }
        }
        System.out.println(lcs[arr1.length][arr2.length]);
    }
}