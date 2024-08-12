import java.util.*;

class Solution {
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
       int[][] times=new int[book_time.length][2];
        
        for(int i=0;i<book_time.length;i++) {
            int start=transToMinute(book_time[i][0]);
            int end=transToMinute(book_time[i][1]);
            
            times[i][0]=start;
            times[i][1]=end+10;
        }
        
        Arrays.sort(times, (o1, o2) -> {
            return o1[0]-o2[0];
        });
        
        for(int i=0;i<times.length;i++) {
            System.out.println(times[i][0]+" "+times[i][1]);
        }
        
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        for(int[] time:times) {
            if(queue.isEmpty()) {
                queue.add(time);
            } else {
                int[] temp=queue.peek();
                int start=temp[0];
                int end=temp[1];
                
                if(time[0]>=end) {
                    queue.poll();
                }
                queue.add(time);
            }
        }
        answer=queue.size(); // 각 호실의 마지막 예약 시간
        return answer;
    }
    
    private int transToMinute(String time) {
        StringTokenizer st=new StringTokenizer(time, ":");
        
        int hour=Integer.parseInt(st.nextToken());
        int minute=Integer.parseInt(st.nextToken());
        
        return hour*60+minute;
    }
}