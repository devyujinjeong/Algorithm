import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // 1. hashmap에 담기
        for(int i=0; i<tangerine.length; i++) {
            hm.put(tangerine[i], hm.getOrDefault(tangerine[i], 0) + 1);
        }
        
        // 2. 개수가 큰 순서대로 정렬하기
        List<Integer> newList = new ArrayList<>(hm.keySet());
        newList.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));
        
        // 3. 앞에서 부터 귤의 개수 차감하기
        for(Integer key : newList) {
            k-=hm.get(key);
            answer++;
            if(k<=0) {
                break;
            }
        }
        
        return answer;
    }
}