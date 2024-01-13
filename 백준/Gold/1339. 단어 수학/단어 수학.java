import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[] word=new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<str.length();j++){
                char c=str.charAt(j);
                word[c-'A']+= (int) Math.pow(10,str.length()-j-1);
            }
        }
        Arrays.sort(word);

        int num=9;
        int index=25;
        int result=0;

        while(word[index]!=0){
            result += word[index]*num;
            num--;
            index--;
        }
        System.out.println(result);
    }
}