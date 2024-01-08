import java.io.*;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        List<Integer> plist=new ArrayList<>();
        List<Integer> nlist=new ArrayList<>();

        for(int i=0;i<N;i++){
            int temp=Integer.parseInt(br.readLine());

            if(temp>0) plist.add(temp);
            else nlist.add(temp);
        }
        plist.sort(reverseOrder());
        Collections.sort(nlist);

        int sum=0;
        int i=0;

        while(i<plist.size()){
            if(i+1<plist.size() && plist.get(i)!=1 && plist.get(i+1)!=1) sum+=plist.get(i++)*plist.get(i++);
            else sum+=plist.get(i++);
        }

        i=0;
        while(i<nlist.size()){
            if(i+1<nlist.size()) sum+=nlist.get(i++)*nlist.get(i++);
            else sum+=nlist.get(i++);
        }
        System.out.println(sum);
    }
}