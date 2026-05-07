import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        List<String> list=Arrays.asList(words);
        
        if (!list.contains(target)) {
            return 0;
        }
        
        int ans=0;
        Queue<String> queue=new LinkedList<>();
        boolean[] visited=new boolean[list.size()];
        
        queue.offer(begin);
        
        while (!queue.isEmpty()) {
            int size=queue.size();
            
            for (int i=0;i<size;i++) { // 동일 레벨을 하나로 묶어서 처리
                String cur=queue.poll();
            
                if (cur.equals(target)) {
                    return ans;
                }

                for (int j=0;j<list.size();j++) {
                    if (!visited[j] && check(cur, list.get(j))) {
                        visited[j]=true;
                        queue.offer(list.get(j));
                    }
                }
            }
            ans++;
        }
        return 0;
    }
    
    static boolean check(String cur, String next) {
        int cnt=0;
        
        for (int i=0;i<cur.length();i++) {
            if (cur.charAt(i)!=next.charAt(i)) cnt++;
        }
        
        if (cnt>1) return false;
        return cnt==1;
    }
}