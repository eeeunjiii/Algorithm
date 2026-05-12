import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] ans=new int[numbers.length];
        Arrays.fill(ans, -1);
        
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        
        for (int i=1;i<numbers.length;i++) {
            while (!stack.isEmpty() && numbers[i]>numbers[stack.peek()]) {
                int index=stack.pop();
                ans[index]=numbers[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            ans[stack.pop()]=-1;
        }
        return ans;
    }
}