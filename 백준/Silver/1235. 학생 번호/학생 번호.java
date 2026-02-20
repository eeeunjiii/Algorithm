import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        String[] arr=new String[N];

        for (int i=0;i<N;i++) {
            arr[i]=br.readLine();
        }

        // 학생의 번호에서 뒤의 K자리만 남겨놓았을 때 모든 학생을 식별할 수 있는 최소 K
        // substring(length-i, length-1) 활용해야 할 듯 (i: 식별하는 데 필요한 자릿수)

        int len=arr[0].length();
        for (int i=1;i<=len;i++) {
            Set<String> set=new HashSet<>();
            for (int j=0;j<N;j++) {
                set.add(arr[j].substring(len-i));
            }

            if (set.size()==N) {
                System.out.println(i);
                return;
            }
        }
    }
}