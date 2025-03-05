import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        // 파기해야 할 개인 정보
        ArrayList<Integer> answer = new ArrayList<>();
        int[] nowDate = Arrays.stream(today.split("\\."))
                            .mapToInt(Integer::parseInt)
                            .toArray();   

        
        Map<String, Integer> map = new HashMap<>();
        
       for (String term : terms) {
            String[] termParts = term.split(" ");
            map.put(termParts[0], Integer.parseInt(termParts[1]));
        }
        
 
        for(int i=0; i<privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            int[] tempDate = Arrays.stream(temp[0].split("\\."))
                            .mapToInt(Integer::parseInt)
                            .toArray();        
            
            int diffYear = nowDate[0] - tempDate[0];
            int diffMonth = nowDate[1] - tempDate[1]; 
            int diffDay = nowDate[2] - tempDate[2];
            
            int diff = diffYear * 12 * 28 + diffMonth * 28 + diffDay;

            if (map.get(temp[1]) * 28 <= diff) {
                answer.add(i + 1);
            }
        }

        
        return answer;
    }
}