import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        String[] str=new String[N];

        for(int i=0;i<N;i++) {
            str[i]=br.readLine();
        }

        int cnt=0;

        // 두개의 다른 알파벳을 하나의 알파벳으로 바꿀 수 X
        // 총 몇개의 쌍이 비슷한지 구하기
        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                boolean flag=true;
                Map<Character, Character> map=new HashMap<>();

                for(int l=0;l<str[i].length();l++) {
                    char origin=str[i].charAt(l);
                    char compare=str[j].charAt(l);

                    if(!map.isEmpty() && map.containsKey(origin)) {
                        if(map.get(origin)!=compare) {
                            flag=false;
                            break;
                        }
                    } else { // 해당 key를 포함하고 있지 않으면
                        // 기존에 있는 value와 compare를 비교
                        Iterator<Character> iterator=map.keySet().iterator();
                        while(iterator.hasNext()) {
                            char next=iterator.next();

                            if(map.get(next)==compare) {
                                flag=false;
                                break;
                            }
                        }
                        map.put(origin, compare);
                    }
                }
                if(flag) cnt++;
            }
        }
        System.out.println(cnt);
    }
}