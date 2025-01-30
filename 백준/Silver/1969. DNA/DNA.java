import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(st.nextToken()); // 주어진 문자열의 개수
        int M=Integer.parseInt(st.nextToken()); // 문자열의 길이
        String[] dna=new String[N];

        for(int i=0;i<N;i++) {
            dna[i]=br.readLine();
        }

        for(int i=0;i<M;i++) {
            int[] cnt=new int[4]; // A, C, G, T

            for(int j=0;j<N;j++) {
                if(dna[j].charAt(i)=='A') cnt[0]++;
                else if(dna[j].charAt(i)=='C') cnt[1]++;
                else if(dna[j].charAt(i)=='G') cnt[2]++;
                else if(dna[j].charAt(i)=='T') cnt[3]++;
            }

            int max=Integer.MIN_VALUE;
            int index=0;
            for(int j=0;j<4;j++) {
                if(max<cnt[j]) {
                    max=cnt[j];
                    index=j;
                }
            }

            if(index==0) sb.append('A');
            else if(index==1) sb.append('C');
            else if(index==2) sb.append('G');
            else if(index==3) sb.append('T');
        }
        System.out.println(sb);
        System.out.println(findDistance(sb.toString(), dna));
    }

    static int findDistance(String ans, String[] dna) {
        int cnt=0;

        for (String s : dna) {
            for (int j = 0; j < ans.length(); j++) {
                if (ans.charAt(j) != s.charAt(j)) cnt++;
            }
        }
        return cnt;
    }
}
class Dna {
    char alpha;
    int cnt;

    public Dna(char alpha, int cnt) {
        this.alpha=alpha;
        this.cnt=cnt;
    }
}