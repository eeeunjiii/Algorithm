import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 단어 사이에 생기는 공간은 N-1
        int M=Integer.parseInt(st.nextToken());
        List<String> list=new ArrayList<>();
        int sum=0;

        for (int i=0;i<N;i++) {
            String str=br.readLine();
            list.add(str);
            sum+=str.length();
        }

        int cnt=(M-sum)/(N-1);
        int mod=(M-sum)%(N-1);
        String line="";
        for (int i=0;i<cnt;i++) {
            line+="_";
        }

        for (int i=0;i<list.size()-1;i++) { // 마지막 단어 뒤에는 언더바 올 수 없음
            list.set(i, list.get(i)+line);
        }

        boolean flag=false;
        if ((M-sum)%(N-1)!=0) {
            for (int i=1;i<list.size();i++) {
                if (list.get(i).charAt(0)>='a' && list.get(i).charAt(0)<='z') {
                    list.set(i-1, list.get(i-1)+"_");
                    mod--;
                }

                if (mod==0) {
                    flag=true;
                    break;
                }
            }
            if (!flag) {
                for (int i=list.size()-1;i>1;i--) {
                    if (list.get(i).charAt(0)>='A' && list.get(i).charAt(0)<='Z') {
                        list.set(i-1, list.get(i-1)+"_");
                        mod--;
                    }
                    if (mod==0) {
                        break;
                    }
                }
            }
        }

        for (String s:list) {
            System.out.print(s);
        }
    }
}