import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] enterOrOut = {"님이 들어왔습니다.", "님이 나갔습니다."};
        ArrayList<String[]> arr = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] info = record[i].split(" ");
            
            String word = info[0];
            String id = info[1];
            
            if(word.equals("Enter")){
                arr.add(new String[] {id, "0"});
                map.put(id, info[2]);
            }else if(word.equals("Leave")){
                arr.add(new String[] {id, "1"});
            }else{
                map.put(id, info[2]);
            }
        }
        
        String[] answer = new String[arr.size()];
        
        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<2; j++){
                String[] temp = arr.get(i);
                String userId = temp[0];
                int idx = Integer.parseInt(temp[1]);
                answer[i] = map.get(userId)+enterOrOut[idx];
            }
        }
        
        return answer;
    }
}