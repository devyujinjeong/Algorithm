class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        if(len==4||len==6){
            for(int i=0; i<len; i++){
                char w = s.charAt(i);
                if(w<48||w>57){
                    answer = false;
                    break;
                }
            }
        }else{
            answer = false;
        }
        
        return answer;
    }
}