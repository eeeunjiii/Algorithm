import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        Character K=st.nextToken().charAt(0); // Y: 윷놀이(임스 같이 한 명), F: 같은 그림 찾기(2명), O: 원카드(3명)

        String[] names=new String[N];
        for(int i=0;i<N;i++) {
            names[i]=br.readLine();
        }

        int cnt=0;
        Set<String> set=new HashSet<>();

        if (K=='Y') {
            for(int i=0;i<N;i++) {
                if(!set.contains(names[i])) {
                    cnt++;
                    set.add(names[i]);
                }
            }
        } else if (K=='F') {
            int flag=0;
            for(int i=0;i<N;i++) {
                if(!set.contains(names[i])) {
                    set.add(names[i]);

                    if(flag==1) {
                        cnt++;
                        flag=0;
                    } else flag++;
                }
            }
        } else {
            int flag=0;
            for(int i=0;i<N;i++) {
                if(!set.contains(names[i])) {
                    set.add(names[i]);

                    if(flag==2) {
                        cnt++;
                        flag=0;
                    } else flag++;
                }
            }
        }
        System.out.println(cnt);
    }
}