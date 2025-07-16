import java.io.*;
import java.util.*;
public class Main {
    static int k,n;
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        k=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());

        line=new int[k];

        long min=0;
        long max=0;

        for(int i=0;i<k;i++){
            line[i]=Integer.parseInt(br.readLine());

            if(line[i]>max){
                max=line[i];
            }
        }
        max++;
        
        while(min<max){
            long mid=(min+max)/2;
            long len=0;

            for(int l:line){
                len+=(l/mid);
            }
            if(len<n){
                max=mid;
            } else{
                min=mid+1;
            }
        }
        System.out.println(min-1);
    }
}