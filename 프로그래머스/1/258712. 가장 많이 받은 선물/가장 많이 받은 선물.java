import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;

        // 친구들의 위치 정보를 저장하고 있는 map
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            map.put(friends[i],i);
        }
        
        // 선물을 어떻게 주고 받았는지 저장하는 배열
        int[][] person = new int[len][len];
        // 친구들의 선물 점수를 저장하는 배열
        int[] giftNum = new int[len]; 
        
        // 선물 정보와 선물 점수 저장하기
        for(int i=0; i<gifts.length; i++){
            String[] name = gifts[i].split(" ");
            int sender = map.get(name[0]);
            int receiver = map.get(name[1]);
            person[sender][receiver]++;
            giftNum[sender]++;
            giftNum[receiver]--; 
        }
        
        // 선물을 각자 몇 개씩 받는지 저장하기
        int[] result = new int[len];
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(person[i][j]>person[j][i]){
                    result[i]++;
                }else if(person[i][j]<person[j][i]){
                    result[j]++;
                }else{
                    if(giftNum[i]>giftNum[j]){
                        result[i]++;  
                    }else if(giftNum[i]<giftNum[j]){
                        result[j]++;
                    }
                }
            }
        }
        
        Arrays.sort(result);
        
        return result[len-1];
    }
}