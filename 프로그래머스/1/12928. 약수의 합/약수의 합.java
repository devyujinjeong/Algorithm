class Solution {
    public int solution(int n) {
        int answer = n;
        
        // 1을 제외하고 남은 공약수 후보들 중 가장 작은 것은 2이므로
        // n/2까지만 범위를 지정해 조사하면 됨
        for(int i=1; i<=n/2; i++){
            if(n%i==0){
                answer+=i;
            }
        }
        
        return answer;
    }
}