import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int N = (int)Math.sqrt(yellow);
        
        for(int i=1; i<=N; i++){
            int j = yellow/i;
            if(yellow%i==0 && (i+j)*2 + 4 == brown) {
                answer[0] = Math.max(i,j)+2;
                answer[1] = Math.min(i,j)+2;
            }   
        }
        
        return answer;
    }
}