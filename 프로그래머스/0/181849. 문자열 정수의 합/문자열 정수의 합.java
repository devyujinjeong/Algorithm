class Solution {
    public int solution(String num_str) {
        int answer = 0;
        
        // 1. num_str을 char형으로 바꾸기
        // 2. 아스키 코드를 이용해 숫자 계산하기 ('1'은 49임)
        for(int i=0; i<num_str.length(); i++){
            answer+=num_str.charAt(i)-48;
        }
        
        return answer;
    }
}