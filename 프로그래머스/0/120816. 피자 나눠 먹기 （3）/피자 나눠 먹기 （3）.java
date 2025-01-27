class Solution {
    public int solution(int slice, int n) {
        // n을 slice로 나눴을 때, 
        // (1) 나머지가 0인 경우 : 인원수를 슬라이스 수로 나누면 됨
        // (2) 나머지가 0이 아닌 경우 : 인원수를 슬라이스 수로 나누고 + 1
        int answer = n%slice==0?n/slice:n/slice+1;
        
        return answer;
    }
}