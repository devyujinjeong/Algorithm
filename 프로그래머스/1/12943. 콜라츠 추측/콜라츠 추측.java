class Solution {
    public int solution(long num) {
        int answer = 0;
        int count = 0;
        
        if(num==1){
            answer = 0;
        }else{
            while(num!=1&&count!=500){
                if(num%2==0){
                    num/=2;
                }else{
                    num=num*3+1;
                }
                count++;
            }
            
            answer = count==500?-1:count;

        }        
        return answer;
    }
}