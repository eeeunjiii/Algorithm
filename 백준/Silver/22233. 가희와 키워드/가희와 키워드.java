import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(st.nextToken()); // 메모장에 적은 키워드 개수
        int M=Integer.parseInt(st.nextToken()); // 블로그에 쓴 글의 개수

        Set<String> memo=new HashSet<>();
        for(int i=0;i<N;i++) {
            memo.add(br.readLine());
        }

        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine(), ",");

            while(st.hasMoreElements()) {
                String word=st.nextToken();
                memo.remove(word);
            }
            System.out.println(memo.size());
        }
    }
}