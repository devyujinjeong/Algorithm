import java.util.*;

class Solution {  
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> userId = new HashMap<>();
        HashMap<String, HashSet<String>> hs = new HashMap<>();

        for(int i=0; i<id_list.length; i++){
            userId.put(id_list[i],i);    
        }
        
        for(String rep : report) {
            String[] names = rep.split(" ");
            String reporter = names[0];
            String reported = names[1]; 

            hs.putIfAbsent(reported, new HashSet<>());
            hs.get(reported).add(reporter);

        }

        for (String reported : hs.keySet()) {
            if (hs.get(reported).size() >= k) {
                for(String name : hs.get(reported)){
                    int idx = userId.get(name);
                    answer[idx]++;
                }
            }
        }


        return answer;
    }
}
