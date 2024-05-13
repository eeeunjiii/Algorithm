import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // 한 photo에 대해서 yearning을 계산
        // name을 List로 변환
        // photo에서 name을 포함하고 있는지 확인
        
        List<String> list=new ArrayList<>(Arrays.asList(name));
        Map<String, Integer> map=new HashMap<>();
        
        for(int i=0;i<name.length;i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(int i=0;i<photo.length;i++) {
            for(int j=0;j<photo[i].length;j++) {
                if(list.contains(photo[i][j])) {
                    answer[i]+=map.get(photo[i][j]);
                }
            }
        }
        
        return answer;
    }
}