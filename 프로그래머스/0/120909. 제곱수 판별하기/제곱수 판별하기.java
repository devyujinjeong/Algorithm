class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int num = (int)Math.sqrt(n);
        answer = num*num ==n?1:2;
        
        return answer;
    }
}