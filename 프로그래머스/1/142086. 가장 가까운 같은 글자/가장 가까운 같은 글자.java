class Solution {
    public int[] solution(String s) {
        int len = s.length();
        String word = "";
        
        char[] alpha = s.toCharArray();
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            if(word.contains(Character.toString(alpha[i]))){
                for(int j=i-1; j>=0; j--){
                    if(alpha[i]==alpha[j]){
                        answer[i] = i-j;
                        break;
                    }
                }
            }else{
                answer[i] = -1;
            }
            
             word+=alpha[i];
        }
        
        return answer;
    }
}