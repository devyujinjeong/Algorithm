class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0;
        int removal = 0;
        
        while(!s.equals("1")) {
            // 원래 문자의 길이
            int temp = s.length();
            
            // 0을 대체하기 
            s = s.replace("0", "");
            
            // removal에 바뀐 0의 개수 더하기
            removal += temp - s.length();
            
            // s를 2진법으로 표현하기
            int num = s.length();
            s = Integer.toBinaryString(num); // 2진법으로 변환하는 메서드
            
            count++;
        }
        
        answer[0] = count;
        answer[1] = removal;
        
        return answer;
    }
}