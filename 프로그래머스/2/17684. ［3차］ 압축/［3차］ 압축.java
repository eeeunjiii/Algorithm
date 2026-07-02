import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> dict=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        
        for (int i=0;i<26;i++) {
            dict.add(i, String.valueOf((char) ('A'+i)));
        }
        
        int i=0;
        while (i<msg.length()) {
            String cur=String.valueOf(msg.charAt(i));
            String temp=cur;
            
            for (int j=i+1;j<msg.length();j++) {
                String next=String.valueOf(msg.charAt(j));
                temp+=next;
                
                if (!dict.contains(temp)) {
                    dict.add(temp);
                    temp=temp.substring(0, temp.length()-next.length());
                    break;
                }   
            }
            list.add(dict.indexOf(temp)+1);
            i+=temp.length();
        }
    
        return list.stream().mapToInt(n->n).toArray();
    }
}