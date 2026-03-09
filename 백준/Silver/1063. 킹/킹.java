import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        char[] king=st.nextToken().toCharArray();
        char[] stone=st.nextToken().toCharArray();
        int N=Integer.parseInt(st.nextToken()); // 움직이는 횟수

        // 킹이 이동했을 때, 돌의 위치와 겹친다면, 돌을 왕이 이동한 같은 방향으로 밀어냄

        for (int i=0;i<N;i++) {
            String command=br.readLine();
            char[] kingNext=move(command, king);

            if (isInRange(kingNext)) {
                if (kingNext[0]==stone[0] && kingNext[1]==stone[1]) {
                    char[] stoneNext=move(command, stone);

                    if (isInRange(stoneNext)) {
                        king=kingNext;
                        stone=stoneNext;
                    }
                } else {
                    king=kingNext;
                }
            }
        }

        String kingResult=String.valueOf(king);
        String stoneResult=String.valueOf(stone);

        System.out.println(kingResult);
        System.out.println(stoneResult);
    }

    static boolean isInRange(char[] arr) {
        if (arr[0]<'A' || arr[0]>'H' || arr[1]<'1' || arr[1]>'8') return false;
        return true;
    }

    static char[] move(String command, char[] target) {
        char[] result=target.clone();

        if (command.equals("R")) {
            result[0]++;
        } else if (command.equals("L")) {
            result[0]--;
        } else if (command.equals("B")) {
            result[1]--;
        } else if (command.equals("T")) {
            result[1]++;
        } else if (command.equals("RT")) {
            result[0]++; result[1]++;
        } else if (command.equals("LT")) {
            result[0]--; result[1]++;
        } else if (command.equals("RB")) {
            result[0]++; result[1]--;
        } else if (command.equals("LB")) {
            result[0]--; result[1]--;
        }
        return result;
    }
}