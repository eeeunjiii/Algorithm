import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize==0) return 5*cities.length;
        
        List<String> list=new ArrayList<>(cacheSize);
        int ans=0;
        
        for (String city:cities) {
            city=city.toUpperCase();
            
            if (list.contains(city)) {
                list.remove(city);
                list.add(city);
                ans+=1;
            } else { // 캐시에 없는 경우
                if (list.size()<cacheSize) { // 캐시에 공간이 있는 경우
                    list.add(city);
                } else { // 캐시에 공간이 없는 경우
                    list.remove(0);
                    list.add(city);
                }
                ans+=5;
            }
        }
        return ans;
    }
}