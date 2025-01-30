class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long s = (long)Math.sqrt(n);
        
        if(s*s==n){
            answer = (s+1)*(s+1);
        }else{
            answer = -1;
        }
        
        return answer;
    }
}