import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer=-1;
        char[] arr=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<arr.length;i++) {
            char temp=arr[i];
            
            if(stack.isEmpty()) stack.push(temp);
            else {
                if(temp==stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            }
        }
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}