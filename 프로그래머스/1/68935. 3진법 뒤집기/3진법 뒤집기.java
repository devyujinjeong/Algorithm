class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int len = 0;
        int tempn = n;
        while(tempn/3!=0){
            tempn/=3;
            len++;
        }
                
        
        for(int i=len; i>=0; i--){
            int div = (int)Math.pow(3,i);
            int temp = n/div;

            answer += (int)Math.pow(3,len-i)*temp;
            n -= temp*div;
        }

        
        return answer;
    }
}