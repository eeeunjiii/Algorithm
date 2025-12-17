import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int M=Integer.parseInt(br.readLine()); // 연산의 수
        Set<Integer> set=new HashSet<>();

        for (int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());

            String command=st.nextToken();
            int num;
            switch (command) {
                case "add":
                    num=Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "remove":
                    num=Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "check":
                    num=Integer.parseInt(st.nextToken());
                    sb.append(set.contains(num) ? 1:0).append("\n");
                    break;
                case "toggle":
                    num=Integer.parseInt(st.nextToken());
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                case "all":
                    set=new HashSet<>();
                    for(int j=1;j<=20;j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}