import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] records) {
        List<String> answer = new LinkedList<>();
        
        Map<String, String> userMap = new HashMap<>();
        String[] orders = new String[records.length];
        String[] ids = new String[records.length];
        
        int i=0;
        for(String record:records) {
            StringTokenizer st=new StringTokenizer(record);
            String status = st.nextToken();
            String userId = st.nextToken();
            
            orders[i]=status;
            ids[i]=userId;
            i++;
            
            if(status.equals("Enter")) {
                String name = st.nextToken();
                userMap.put(userId, name);
            } else if(status.equals("Change")) {
                String newName = st.nextToken();
                userMap.replace(userId, newName);
            }
        }
        
        for(int j=0;j<records.length;j++) {
            if(orders[j].equals("Enter")) {
                answer.add(userMap.get(ids[j])+"님이 들어왔습니다.");
            } else if(orders[j].equals("Leave")) {
                answer.add(userMap.get(ids[j])+"님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}