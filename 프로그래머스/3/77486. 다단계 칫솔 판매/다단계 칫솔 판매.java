import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        int len = enroll.length;
        int[] result = new int[len];
        
        HashMap<String, Integer> position = new HashMap<>();
        
        for(int i=0; i<len; i++){
            // 모든 사람들의 위치 저장하기
            position.put(enroll[i], i);
        }
        
        for(int i=0; i<seller.length; i++){
            // seller의 위치 찾기
            int idx = position.get(seller[i]);
            int money = amount[i]*100;
            // seller의 부모의 값 갱신하기
            while(money>0){
                // seller의 금액 (10% 금액 지불 한 경우)
                int commission = money / 10;
                result[idx] += money - commission;
                
                if(referral[idx].equals("-")){
                    break;
                }
                
                money = commission;
                idx = position.get(referral[idx]);
            }
            
        }
        
        return result;
    }
}