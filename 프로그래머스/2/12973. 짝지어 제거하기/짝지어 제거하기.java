
import java.util.*;
class Solution{
    public int solution(String s){
        int answer = 0;
        

        Stack<Character> word = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(!word.isEmpty()&& word.peek() == temp){
                word.pop();
            }else{
                word.push(temp);
            }
        }        
        
        answer = word.isEmpty()?1:0;
        
        return answer;
    }
}