import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N+1][2]; // S, T

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                else return o1[0]-o2[0];
            }
        });

        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(arr[0][1]);

        for(int i=1;i<N;i++){
            if(queue.peek()<=arr[i][0]) queue.poll();
            queue.add(arr[i][1]);
        }
        System.out.println(queue.size()); // queue.size == 필요한 강의실의 수
    }
}