import java.io.*;
import java.util.*;

public class Main {

    static char[] duck={'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String line=br.readLine();
        char[] arr=line.toCharArray();
        boolean[] visited=new boolean[arr.length];

        if (arr[0]!='q' || arr.length%5!=0) { // 여러 마리의 오리가 있다면 사용되지 않는 문자가 있으면 안됨.
            System.out.println(-1);
            return;
        }

        int idx=0;
        int cnt=0;
        for (int i=0;i<arr.length;i++) {
            List<Character> list=new ArrayList<>();
            for (int j=i;j<arr.length;j++) {
                if (!visited[j] && arr[j]==duck[idx]) {
                    idx++;
                    list.add(arr[j]);
                    visited[j]=true;

                    if (idx==5) {
                        idx = 0;
                        // 한 문자열은 한 오리가 낸 소리이기 때문에 break가 있으면 안 됨.
                    }
                }
            }

            if (!list.isEmpty()) {
                if (list.get(list.size()-1)!='k') {
                    System.out.println(-1);
                    return;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}