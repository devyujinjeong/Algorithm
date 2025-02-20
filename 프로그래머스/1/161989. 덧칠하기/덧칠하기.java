class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int finished = 0;
        
        for(int i=0; i<section.length; i++){
            if(finished<section[i]){
                finished = section[i]+m-1;
                answer++;
            }
        }
        
        
        return answer;
    }
}