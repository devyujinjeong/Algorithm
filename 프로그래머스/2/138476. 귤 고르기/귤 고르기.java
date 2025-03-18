import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> valueList = new LinkedList<>(map.values());
        valueList.sort((o1,o2) -> o2-o1);


        for (Integer value : valueList) {
            k-=value;
            if(k>0){
                answer++;
            }else{
                break;
            }
        }
        
        return answer;
    }
}
