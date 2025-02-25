class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int count = 0;
            char temp = c;
            
            while (count < index) {
                temp++;
                
                // 만약 'z' 다음으로 가면 다시 'a'로 순환
                if (temp > 'z') {
                    temp = 'a';
                }
                
                // skip에 포함되지 않은 경우만 count 증가
                if (!skip.contains(String.valueOf(temp))) {
                    count++;
                }
            }
            
            answer.append(temp);
        }
        
        return answer.toString();
    }
}
