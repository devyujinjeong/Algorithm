import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> rightMap = new HashMap<>();
        Set<Integer> leftSet = new HashSet<>();

        // 처음에 모든 토핑은 오른쪽에 있음
        for (int top : topping) {
            rightMap.put(top, rightMap.getOrDefault(top, 0) + 1);
        }

        // 한 칸씩 왼쪽으로 옮기면서 체크
        for (int i = 0; i < topping.length; i++) {
            int current = topping[i];

            // 왼쪽 Set에 추가
            leftSet.add(current);

            // 오른쪽 Map에서 개수 줄이기
            rightMap.put(current, rightMap.get(current) - 1);
            if (rightMap.get(current) == 0) {
                rightMap.remove(current);
            }

            // 둘의 종류 수가 같으면 공평한 컷!
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}
