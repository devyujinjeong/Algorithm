class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] power = {5,3,1};
        
        int i=0;
        while(hp!=0){
            answer += hp/power[i];
            hp = hp%power[i];
            i++;
        }
        
        return answer;
    }
}