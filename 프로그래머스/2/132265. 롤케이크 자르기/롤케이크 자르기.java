import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        // 오른쪽 토핑: 종류별 개수 카운트
        HashMap<Integer, Integer> right = new HashMap<>();
        HashSet<Integer> left = new HashSet<>();
        
        for(int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++) {
            // 왼쪽에 토핑 추가
            left.add(topping[i]);
            // 오른쪽에서 토핑 하나 제거
            right.put(topping[i], right.get(topping[i]) - 1);
            
            int count1 = left.size();    // 왼쪽 토핑 종류 수
            
            // 오른쪽에서 특정 토핑이 다 빠졌다면 종류 수 감소
            if(right.get(topping[i]) == 0) {
                right.remove(topping[i]);
            }
            
            int count2 = right.size();   // 오른쪽 토핑 종류 수
            
            // 양쪽 종류 수가 같으면 정답++
            if(count1 == count2) {
                answer++;
            }
        }
        
        return answer;
    }
}
