import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2); // 맨 앞 '{{', 맨 뒤 '}}' 제거
        String[] arr = s.split("},\\{");   // 중간 집합들 분리
        
        Arrays.sort(arr, (a, b) -> a.length() - b.length()); // 길이 기준 정렬
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        for (String group : arr) {
            String[] numbers = group.split(",");
            for (String num : numbers) {
                int value = Integer.parseInt(num);
                if (!seen.contains(value)) {
                    seen.add(value);
                    result.add(value);
                }
            }
        }
        
        // List → int[] 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
