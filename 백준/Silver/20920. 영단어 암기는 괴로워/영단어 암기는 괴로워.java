import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        Map<String, Integer> map=new HashMap<>();

        for(int i=0;i<N;i++) {
            String word=br.readLine();
            if(word.length()<M) continue;

            map.put(word, map.getOrDefault(word, 0)+1);
        }

        List<String> key=new ArrayList<>(map.keySet());

        Collections.sort(key, (o1, o2) -> {
            if((int) map.get(o1) != map.get(o2)) {
                return Integer.compare(map.get(o2), map.get(o1));
            }

            if(o1.length()!=o2.length()) {
                return o2.length()-o1.length();
            }
            return o1.compareTo(o2);
        });

        StringBuilder sb=new StringBuilder();
        for(String word:key) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}