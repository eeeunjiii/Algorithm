import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double h = Double.parseDouble(st.nextToken());
        double w = Double.parseDouble(st.nextToken());
        double n = Double.parseDouble(st.nextToken());
        double m = Double.parseDouble(st.nextToken());

        int x = (int) Math.ceil(h/(n+1));
        int y = (int) Math.ceil(w/(m+1));

        System.out.println(x*y);
    }
}