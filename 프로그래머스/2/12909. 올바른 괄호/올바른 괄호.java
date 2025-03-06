import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        boolean isRight = true;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else if(stack.isEmpty()){
                isRight = false;
                break;
            }else{
                stack.pop();
            }
        }
        
        if(isRight&&stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}