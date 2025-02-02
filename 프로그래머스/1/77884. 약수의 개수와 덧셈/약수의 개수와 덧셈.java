class Solution {
    int countDivisor(int n){
        if(n==1){
            return 1;
        }else{
            int count = 2;
            for(int i=2; i<=n/2; i++){
                if(n%i==0){
                    count++;
                }
            }
            return count;
        }

    }
    
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            if(countDivisor(i)%2==0){
                answer += i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }
}