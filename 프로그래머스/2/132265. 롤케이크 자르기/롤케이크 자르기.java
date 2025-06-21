import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            // 왼쪽으로 옮기기
            leftMap.put(t, leftMap.getOrDefault(t, 0) + 1);

            // 오른쪽에서 제거
            rightMap.put(t, rightMap.get(t) - 1);
            if (rightMap.get(t) == 0) {
                rightMap.remove(t);
            }

            if (leftMap.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}
