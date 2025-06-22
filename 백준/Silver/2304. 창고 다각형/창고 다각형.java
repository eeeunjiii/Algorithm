import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] pillar=new int[1001];
        int start=Integer.MAX_VALUE;
        int end=0;

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            int L=Integer.parseInt(st.nextToken());
            int H=Integer.parseInt(st.nextToken());

            pillar[L]=H;
            start=Math.min(L, start);
            end=Math.max(L, end);
        }

        Stack<Integer> stack=new Stack<>();

        int temp=pillar[start];
        for(int i=start+1;i<=end;i++) {
            if(pillar[i]<temp) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()) {
                    int v=stack.pop();
                    pillar[v]=temp;;
                }
                temp=pillar[i];
            }
        }

        stack.clear();

        temp=pillar[end];
        for(int i=end-1;i>=start;i--) {
            if(pillar[i]<temp) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()) {
                    int v=stack.pop();
                    pillar[v]=temp;
                }
                temp=pillar[i];
            }
        }

        int sum=0;
        for(int i=start;i<=end;i++) {
            sum+=pillar[i];
        }
        System.out.println(sum);
    }
}