class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        // 아스키 코드를 이용 : 'a'=97, 'A'=65
        
        for(int i=0; i<my_string.length(); i++){
            int word_as = my_string.charAt(i);
            if(word_as<97){
                answer += (char)(word_as+32);
            }else{
                answer += (char)(word_as-32);
            }
        }

        
        return answer;
    }
}