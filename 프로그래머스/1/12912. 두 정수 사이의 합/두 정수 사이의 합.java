class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int e = a>b?a:b;
        int s = a<=b?a:b;
            
        for(int i=s; i<=e; i++){
            answer +=i;    
        }
        
        return answer;
    }
}