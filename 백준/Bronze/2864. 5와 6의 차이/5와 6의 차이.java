import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        
        String str1=String.valueOf(A);
        String str2=String.valueOf(B);
        
        int maxValue=Integer.parseInt(str1.replace('5', '6'))+Integer.parseInt(str2.replace('5','6'));
        int minValue=Integer.parseInt(str1.replace('6', '5'))+Integer.parseInt(str2.replace('6', '5'));
        
        System.out.println(minValue+" "+maxValue);
    }

}