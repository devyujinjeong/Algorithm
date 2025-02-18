class Solution {

    int countDivisor(int number){
        if(number ==1){
            return 1;
        }else{
            int count = 2;
            int div = (int)Math.sqrt(number);
            for(int i=2; i<=div; i++){
                if(number%i==0){
                    if(i*i==number){
                        count++;
                    }else{
                        count+=2;
                    }
                }        
            }
            
            return count; 
        }
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
                
        for(int i=1; i<=number; i++){
           if(countDivisor(i)<=limit){
               answer+=countDivisor(i);
           }else {
               answer+=power;
           }
        }
        
        return answer;
    }
}