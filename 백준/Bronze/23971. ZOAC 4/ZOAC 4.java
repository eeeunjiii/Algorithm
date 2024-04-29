import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        double H=Double.parseDouble(st.nextToken());
        double W=Double.parseDouble(st.nextToken());
        double N=Double.parseDouble(st.nextToken());
        double M=Double.parseDouble(st.nextToken());

        int height=(int) Math.ceil(H/(N+1));
        int width=(int) Math.ceil(W/(M+1));

        System.out.println(height*width);
    }
}