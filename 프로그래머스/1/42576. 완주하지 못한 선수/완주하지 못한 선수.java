import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> runner = new HashMap<>();

        for (String p : participant) {
            runner.put(p, runner.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            runner.put(c, runner.get(c) - 1);
        }

        for (String key : runner.keySet()) {
            if (runner.get(key) != 0) {
                return key;
            }
        }
        
        return ""; 
    }
}
