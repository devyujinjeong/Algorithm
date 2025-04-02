import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {     
        Map<String, Integer> runner = new HashMap<>();
        
        for(String person : participant){
            runner.put(person,runner.getOrDefault(person,0)+1);
        }
        
        for(String person : completion){
            runner.put(person,runner.get(person)-1);
        }
        
        for(String key : runner.keySet()){
            if(runner.get(key)!=0){
                return key;
            }
        }
        
        return "";
    }
}