class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // bandage: 시전 시간, 초당 회복량, 추가 회복량
        // 0. 최대 체력 이상의 값은 가질 수 없다. 
        // 1. attacks의 크기만큼 (시간) 반복문 진행
        // 2. attacks가 있는 시간에 도달하면 해당 값만큼 체력 감소
        // 3. attacks가 없다면 체력 회복 수만큼 증가
        // 4. 주어진 시간을 연속으로 성공하면 추가 체력만큼 증가 (연속 성공 값 초기화 seq)
        // 5. 공격을 받으면 연속 성공 초기화
        
        int len=attacks.length;
        int maxTime=attacks[len-1][0];
        int curHealth=health;
        int seq=0; // 연속 성공
        int j=0; // 공격 시간 attacks
        
        for(int i=1;i<=maxTime;i++) {
            if(i!=attacks[j][0]) {
                curHealth+=bandage[1];
                seq++;
                
                if(seq==bandage[0]) {
                    curHealth+=bandage[2];
                    seq=0;
                }
                
                if(curHealth>health) curHealth=health;
            } else {
                curHealth-=attacks[j][1];
                j++;
                seq=0;
                
                if(curHealth<=0) return -1;
            }
        }
        
        return curHealth;
    }
}