import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        int gcd=GCD(arr[0], arr[1]);
        int lcm=(arr[0]*arr[1])/gcd;
        
        for(int i=2;i<arr.length;i++) {
            gcd=GCD(lcm, arr[i]);
            lcm=(lcm*arr[i])/gcd;
        }
        
        return lcm;
    }
    
    static int GCD(int num1, int num2) {
        if(num1%num2==0) return num2;
        return GCD(num2, num1%num2);
    }
}