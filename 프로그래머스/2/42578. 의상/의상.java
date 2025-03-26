import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int len = clothes.length;
        Map<String, Integer> matches = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            String item = clothes[i][0];
            String kind = clothes[i][1];
            matches.put(kind, matches.getOrDefault(kind, 0) + 1);
        }
        int answer = 1;
        
        for(String key: matches.keySet()) {
            answer *= matches.get(key) + 1;
        }

        return answer - 1;
        
    }
}