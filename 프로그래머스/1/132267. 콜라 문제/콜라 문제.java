class Solution {
    public long solution(int a, int b, int n) {
        long answer = 0;

        while(n>=a){
            int r = n/a*b;
            answer+=r;
            n = n%a+r;  
        }

        return answer;
    }
}   