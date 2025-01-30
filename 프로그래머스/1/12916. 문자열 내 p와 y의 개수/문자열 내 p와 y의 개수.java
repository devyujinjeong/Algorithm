class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int p = 0;
        int y = 0;
        
        for(int i=0; i<s.length(); i++){
            char word = s.charAt(i);
            if(word=='p'||word=='P'){
                p++;
            }else if(word=='y'||word=='Y'){
                y++;
            }
        }

        if(p!=y){
            answer = false;
        }
        
        return answer;
    }
}