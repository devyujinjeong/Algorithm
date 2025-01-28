import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        // score 배열의 크기
        int n = score.length;
        
        while(n-m>=0){
            answer+=score[n-m]*m;
            n = n-m;
        }

        return answer;
    }
}