class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health; // 체력
        int count = 0; // 시전 시간
        int j = 0; // 공격 인덱스
        
        // 마지막 공격이 있는 시간까지 반복
        for(int i=1; i<=attacks[attacks.length-1][0]; i++){
            if(i==attacks[j][0]){ // 공격을 받는 시간
                answer -= attacks[j][1];
                j++;
                count = 0;
            }else{ // 공격을 받지 않는 시간
                count++;
                if(answer+bandage[1]<=health){ // 최대 체력을 넘지 않음
                    answer += bandage[1]; 
                    
                    if(count==bandage[0]){
                        answer += bandage[2]; 
                        count = 0;
                    }
                }else{
                    answer = health;
                    if(count==bandage[0]) count = 0;
                }      
            }
            
            if(answer<=0){
                return -1;
            }
        }
        
        return answer;
    }
}