class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int len = 0;
        int tempn = n;
        while(tempn/3!=0){
            tempn/=3;
            len++;
        }
                
        int[] ternary = new int[len+1];
        
        for(int i=len; i>=0; i--){
            int div = (int)Math.pow(3,i);
            // 자리별로 0,1,2중 어떤 값이 나오는지 계산하기
            int temp = n/div;
            
            // 숫자 뒤집기
            ternary[len-i] = temp;
            n -= temp*div;
            
            // 10진법으로 다시 바꾸기
            answer += (int)Math.pow(3,len-i)*ternary[len-i];
        }

        
        return answer;
    }
}