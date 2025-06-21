import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;

        // 오른쪽에 다 저장한 다음에 왼쪽으로 옮기면서 비교하기
        HashMap<Integer, Integer> right = new HashMap<>();
        HashSet<Integer> left = new HashSet<>();
        
        for(int i=0; i<len; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=0; i<len; i++) {
            left.add(topping[i]);
            right.put(topping[i], right.get(topping[i]) - 1);
            
            int count2 = left.size();
            
            if(right.get(topping[i]) == 0){
                right.remove(topping[i]);
            }
                        
            int count1 = right.size();
            
            if(count1 == count2) answer++;
            
        }
        
        return answer;
    }
}