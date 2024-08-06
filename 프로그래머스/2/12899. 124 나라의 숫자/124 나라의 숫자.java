class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr={"4","1","2"}; // 3의 배수로 나누었을 때의 나머지
        
        while(n>0) {
            answer = arr[n%3]+answer;
            n = (n-1)/3;
        }
        
        return answer;
    }
}