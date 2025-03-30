import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        Queue<String> q = new ArrayDeque<>();
        
        for(String word : goal){
            q.add(word);
        }
        
        int idx1 = 0;
        int idx2 = 0;
        for(int i=0; i<goal.length; i++){
            String temp = q.poll();
            if(idx1<cards1.length&&temp.equals(cards1[idx1])){
                idx1++;
            }else if(idx2<cards2.length&&temp.equals(cards2[idx2])){
                idx2++;
            }else{
                return "No";
            } 
            
            if(q.isEmpty()){
                break;
            }
        }
        
        return answer;
    }
}