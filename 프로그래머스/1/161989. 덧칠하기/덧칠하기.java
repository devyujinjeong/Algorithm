class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int finished = 0;
        int len = section.length;
        
        for(int i=0; i<len; i++){
            if(finished<section[i]){
                finished = section[i]+m-1;
                answer++;
            }

            if(finished>=section[len-1]){
                break;
            }
        }
        
        
        return answer;
    }
}