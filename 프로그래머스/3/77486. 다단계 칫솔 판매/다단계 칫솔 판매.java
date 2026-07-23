import java.util.*;

class Solution {
    static int[] ans;
    static List<String> enrollList;
    static List<String> referralList;
    
    public int[] solution(String[] enroll, String[] referral, 
                          String[] seller, int[] amount) {
        // 칫솔 하나를 판매하여 얻는 이익==100원
        // enroll: 각 노드, referral: 부모 노드
        ans=new int[enroll.length];
        enrollList=new ArrayList<>(Arrays.asList(enroll));
        referralList=new ArrayList<>(Arrays.asList(referral));
        
        for (int i=0;i<seller.length;i++) {
            String s=seller[i];
            int a=amount[i];
            
            int total=a*100;
            
            process(s, total);
        }
        return ans;
    }
    
    static public void process(String seller, int total) {        
        int idx=enrollList.indexOf(seller);
        
        if (total*0.1<1) {
            ans[idx]+=total;
            return;
        }
        
        String next=referralList.get(idx);
        if (next.equals("-")) {
            ans[idx]+=total-total/10;
            return;
        } else {            
            ans[idx]+=total-total/10;
            process(next, total/10);
            return;
        }
    }
}