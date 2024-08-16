import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int H=Integer.parseInt(st.nextToken()); // 높이(행)
        int W=Integer.parseInt(st.nextToken()); // 너비(열)
        int[] arr=new int[W];
        int maxW=0;
        int maxH=Integer.MIN_VALUE;

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<W;i++) {
            arr[i]=Integer.parseInt(st.nextToken());

            if(maxH<arr[i]) {
                maxH=arr[i];
                maxW=i;
            }
        }

        int sum=0;
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<maxW;i++) {
            if(stack.isEmpty()) {
                stack.push(new int[]{i, arr[i]});
            } else if(stack.peek()[1]>arr[i]) {
                sum+=stack.peek()[1]-arr[i];
            } else if(stack.peek()[1]<=arr[i]) {
                stack.pop();
                stack.push(new int[]{i, arr[i]});
            }
        }

        stack=new Stack<>();
        for(int i=W-1;i>maxW;i--) {
            if(stack.isEmpty()) {
                stack.push(new int[]{i, arr[i]});
            } else if(stack.peek()[1]>arr[i]) {
                sum+=stack.peek()[1]-arr[i];
            } else if(stack.peek()[1]<=arr[i]) {
                stack.pop();
                stack.push(new int[]{i, arr[i]});
            }
        }

        System.out.println(sum);
    }
}