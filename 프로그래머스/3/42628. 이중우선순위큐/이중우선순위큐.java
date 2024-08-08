import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation:operations) {
            StringTokenizer st=new StringTokenizer(operation);
            String command=st.nextToken();
            Integer num=Integer.parseInt(st.nextToken());
            
            if(command.equals("I")) {
                minHeap.add(num);
                maxHeap.add(num);
            } else {
                if(num==1 && !maxHeap.isEmpty()) {
                    minHeap.remove(maxHeap.poll());
                } else if(num==-1 && !minHeap.isEmpty()) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        if(!maxHeap.isEmpty()) {
            answer[0]=maxHeap.poll();
        } else {
            answer[0]=0;
        }
        
        if(!minHeap.isEmpty()) {
            answer[1]=minHeap.poll();
        } else {
            answer[1]=0;
        }
        
        return answer;
    }
}