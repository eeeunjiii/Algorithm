import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());

        String line=br.readLine();
        String ans="";

        String replaced = line.replaceAll("XXXX", "AAAA");
        ans = replaced.replaceAll("XX", "BB");

        if(ans.contains("X")) ans="-1";
        System.out.println(ans);
    }
}