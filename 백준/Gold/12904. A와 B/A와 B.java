import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static String T;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        S=br.readLine();
        T=br.readLine();

        while(S.length()<T.length()) {
            StringBuffer sb=new StringBuffer();

            if(T.endsWith("A")) {
                T=T.substring(0, T.length()-1);
            } else if(T.endsWith("B")) {
                T=T.substring(0, T.length()-1);
                T=sb.append(T).reverse().toString();
            }
        }

        if(S.equals(T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
