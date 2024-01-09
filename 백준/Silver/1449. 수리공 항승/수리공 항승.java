import java.io.*;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());

        int[] value=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            value[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);
        
        double temp = value[0] - 0.5;
        int cnt = 1;
        
        for(int i=0; i<N; i++) {
            if(temp+L < value[i]) {
                cnt++;
                temp = value[i] - 0.5;
            }
        }
        System.out.println(cnt);
    }
}