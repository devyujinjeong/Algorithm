import java.util.*;

class Solution {  
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> reportMap = new HashMap<>();

        for (String rep : report) {
            String[] names = rep.split(" ");
            String reporter = names[0];
            String reported = names[1]; 

            reportMap.putIfAbsent(reported, new HashSet<>());
            reportMap.get(reported).add(reporter); 
        }

        HashMap<String, Integer> result = new HashMap<>();
        for (String reported : reportMap.keySet()) {
            if (reportMap.get(reported).size() >= k) {
                for (String reporter : reportMap.get(reported)) {
                    result.put(reporter, result.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = result.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
