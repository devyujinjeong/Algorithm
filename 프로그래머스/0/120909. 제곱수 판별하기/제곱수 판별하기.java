class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 1. n의 제곱근 구하고 int로 자료형 변환하기
        int num = (int)Math.sqrt(n);
        
        // 2. num을 제곱한 수와 n을 비교하기
        answer = num*num ==n?1:2;
        
        return answer;
    }
}