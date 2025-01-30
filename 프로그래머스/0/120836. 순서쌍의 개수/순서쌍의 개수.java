class Solution {
    public int solution(int n) {
        int answer = 0;
        
        
        for(int i=1; i<=(int)Math.sqrt(n); i++){
            if(n%i==0){
                if(i*i==n){
                    answer++;
                }else{
                    answer = answer+2;

                }
            }
        }
        
        return answer;
    }
}