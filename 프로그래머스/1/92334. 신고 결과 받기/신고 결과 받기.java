import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 유저의 아이디 저장하기
        HashMap<String, Integer> userId = new HashMap<>();
        // 각 유저별 신고 당한 경우 저장하기
        HashMap<String, HashSet<String>> reportList = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            userId.put(id_list[i], i);
        }
        
        for(int i=0; i<report.length; i++){
            String[] temp = report[i].split(" ");
            reportList.putIfAbsent(temp[1], new HashSet<>());
            reportList.get(temp[1]).add(temp[0]);
        }
        
        for(String key : reportList.keySet()){
            if(reportList.get(key).size()>=k){
                for(String name :  reportList.get(key)){
                     int idx = userId.get(name);
                    answer[idx]++;
                }
            }
        }

        
        return answer;
    }
}