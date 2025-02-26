class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer();
        // 모든 단어를 소문자로 변환하기
        s = s.toLowerCase();  
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 

            // 만약에 공백이라면 공백 추가
            if (c == ' ') {
                sb.append(' '); 
            }
            // 첫 글자이거나 그 전이 공백이면 대문자로 변환
            else if (i == 0 || s.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(c));  // 대문자로 변환하여 추가
            } 
            // 나머지 문자는 그대로 소문자로
            else {
                sb.append(c);
            }
        }
        
        return sb.toString(); 
    }
}
