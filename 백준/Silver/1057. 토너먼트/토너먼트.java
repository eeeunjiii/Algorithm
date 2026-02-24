import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int J=Integer.parseInt(st.nextToken());
        int H=Integer.parseInt(st.nextToken());

        int cnt=0;
        while (J!=H) {
            J=(J/2)+(J%2);
            H=(H/2)+(H%2);
            cnt++;
        }
        System.out.println(cnt);
    }
}