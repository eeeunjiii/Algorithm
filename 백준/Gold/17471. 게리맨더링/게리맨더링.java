import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N; // 구역의 개수
    private static int[] people; // 인구 수 -> 두 구역의 인구 수를 최소로
    private static boolean[] visited;
    private static boolean[] selected;
    private static ArrayList<ArrayList<Integer>> graph =new ArrayList<>(); // 인접한 구역의 수, 인접한 구역의 번호
    private static int ans=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        people=new int[N];
        selected=new boolean[N];

        for(int i=0;i<N;i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            people[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());

            for(int j=0;j<num;j++) {
                int temp=Integer.parseInt(st.nextToken());
                graph.get(i).add(temp-1);
            }
        }
        divide(0);
        if(ans==Integer.MAX_VALUE) ans=-1;
        System.out.println(ans);
    }
    private static void divide(int idx) {
        if(idx==N) {
            List<Integer> list1=new ArrayList<>();
            List<Integer> list2=new ArrayList<>();

            for(int i=0;i<N;i++) {
                if(selected[i]) list1.add(i);
                else list2.add(i);
            }
            if(list1.isEmpty() || list2.isEmpty()) return;
            if(check(list1) && check(list2)) {
                getDiff();
            }
            return;
        }
        selected[idx]=true;
        divide(idx+1);
        selected[idx]=false;
        divide(idx+1);
    }

    private static boolean check(List<Integer> list) {
        Queue<Integer> queue=new LinkedList<>();
        visited=new boolean[N];
        visited[list.get(0)]=true;
        queue.offer(list.get(0));

        int cnt=1; // 방문한 지역 개수
        while(!queue.isEmpty()) {
            int v=queue.poll();
            for(int i=0;i<graph.get(v).size();i++) {
                int l=graph.get(v).get(i);
                if(list.contains(l) && !visited[l]) {
                    queue.offer(l);
                    visited[l]=true;
                    cnt++;
                }
            }
        }
        if(cnt==list.size()) return true;
        else return false;
    }

    private static void getDiff() {
        int sum1=0;
        int sum2=0;

        for(int i=0;i<N;i++) {
            if(selected[i]) sum1+=people[i];
            else sum2+=people[i];
        }

        int diff=Math.abs(sum1-sum2);
        ans=Math.min(diff, ans);
    }
}