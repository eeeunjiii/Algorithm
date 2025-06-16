import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static char[] vowels={'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        while(true) {
            String str=br.readLine();

            if(str.equals("end")) {
                break;
            } else {
                char[] arr=str.toCharArray();
                int[] check=new int[arr.length];
                int vowelCnt=0;
                boolean flag=true;

                for(int i=0;i<arr.length;i++) {
                    for(int j=0;j<vowels.length;j++) {
                        if(arr[i]==vowels[j]) {
                            check[i]=0; // 모음이면 0을 저장
                            vowelCnt++;
                            break;
                        } else {
                            check[i]=1; // 자음이면 1을 저장
                        }
                    }
                }

                if(vowelCnt>=1) {
                    String num= Arrays.toString(check).replace("[", "").replace("]", "").replace(", ", "");

                    if(num.contains("111") || num.contains("000")) flag=false;

                    char prev=arr[0];
                    for(int i=1;i<arr.length;i++) {
                        char cur=arr[i];

                        if(prev!=cur) {
                            prev=arr[i];
                        }
                        else if(prev == 'e' || prev=='o') prev=arr[i];
                        else {
                            flag=false;
                        }
                    }
                } else {
                    flag=false;
                }

                if(flag) sb.append("<").append(str).append("> ").append("is acceptable.").append("\n");
                else sb.append("<").append(str).append("> ").append("is not acceptable.").append("\n");
            }
        }
        System.out.println(sb);
    }
}