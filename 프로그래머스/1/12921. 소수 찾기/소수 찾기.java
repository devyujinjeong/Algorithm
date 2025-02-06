class Solution {
    boolean findPrime(int a){
        boolean check = true;
        for(int i=2; i<=(int)Math.sqrt(a); i++){
            if(a%i==0){
                check = false;
                break;
            }
        }
        
        return check;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        for(int i=2; i<=n; i++){
            if(findPrime(i)){
                answer++;
            }
        }
        
        return answer;
    }
}