class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // n-1을 나눌 수 있는 가장 작은 수를 구하면 됨(1제외) 
        for(int i=2;i<=n-1;i++){
            if((n-1)%i==0){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}