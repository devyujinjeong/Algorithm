import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Stack<Character> alphabet = new Stack<>();
        
        for(int i= skill.length() - 1; i>=0; i--) {
            alphabet.push(skill.charAt(i));
        }

        for(String word : skill_trees) {
            int count = 0;
            for(int i=0; i<word.length(); i++) {
                char cur = word.charAt(i);
                
                if(!alphabet.isEmpty() && cur == alphabet.peek()) {
                    alphabet.pop();
                } else if(alphabet.contains(cur)) {
                    break;
                }   
                
                count++;
            }
            
            for(int i= skill.length() - 1; i>=0; i--) {
                alphabet.push(skill.charAt(i));
            }
            
            if(count==word.length()) {
                answer++;
            }
        }
        
        return answer;
    }
}