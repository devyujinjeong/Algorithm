class Solution {
    public long solution(int price, long money, int count) {
        long answer = 0;

        for(int i=1; i<=count; i++){
            money -= price*i;
        }
        
        answer = money>=0?0:-money;
        
        return answer;
    }
}