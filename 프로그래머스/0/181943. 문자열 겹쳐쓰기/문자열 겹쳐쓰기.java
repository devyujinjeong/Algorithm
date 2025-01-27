class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        // 1. my_string을 char로 바꾼 뒤 배열에 저장하기
        // 2. s부터 overwrite_string의 길이만큼 글자 바꾸기
        char[] word = new char[my_string.length()];
        
        for(int i=0; i<my_string.length();i++){
            word[i] = my_string.charAt(i);
        }
        
        for(int i=s; i<s+overwrite_string.length(); i++){
            word[i] = overwrite_string.charAt(i-s);
        }
        
        for(int i=0; i<my_string.length();i++){
            answer+=word[i];
        }
        
        return answer;
    }
}