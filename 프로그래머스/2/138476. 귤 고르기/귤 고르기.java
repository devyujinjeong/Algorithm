import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> keyList = new LinkedList<>(map.keySet());
        keyList.sort((o1,o2) -> map.get(o2)-map.get(o1));


        for (Integer key : keyList) {
            k-=map.get(key);
            if(k>0){
                answer++;
            }else{
                break;
            }
        }
        
        return answer;
    }
}
