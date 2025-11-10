import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=getGameType(st.nextToken().charAt(0)); // Y: 윷놀이(임스 같이 한 명), F: 같은 그림 찾기(2명), O: 원카드(3명)

        Set<String> set=new HashSet<>();
        int cnt=0;
        
        while (N-->0) {
            String name=br.readLine();
            cnt+=set.contains(name) ? 0:1;
            set.add(name);
        }
        System.out.println(cnt/K);
    }
    
    private static int getGameType(char c) {
        switch (c) {
            case 'Y': return 1;
            case 'F': return 2;
            case 'O': return 3;
        }
        return -1;
    }
}