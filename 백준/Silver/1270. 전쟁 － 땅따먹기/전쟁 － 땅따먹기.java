import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine()); // 땅의 개수

        // 어느 땅에서 한 번호의 군대의 병사가 절반을 초과한다면
        // 그 땅은 그 번호의 군대의 지배하에 놓임
        // 각 땅들을 지배한 군대의 번호 출력 (진행중인 경우 "SYJKGW" 출력)

        StringTokenizer st;
        for (int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());

            int M=Integer.parseInt(st.nextToken());
            Map<Long, Integer> map=new HashMap<>();

            int max=0;
            Long idx=0L;

            for (int j=0;j<M;j++) {
                long v=Long.parseLong(st.nextToken());

                if (map.containsKey(v)) {
                    map.replace(v, map.get(v)+1);
                } else {
                    map.put(v, 1);
                }

                if (map.get(v)>max) {
                    max=map.get(v);
                    idx=v;
                }
            }

            if (max>M/2) System.out.println(idx);
            else System.out.println("SYJKGW");

            map.clear();
        }
    }
}