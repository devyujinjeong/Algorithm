import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int len = sizes.length;
        int[] w = new int[len];
        int[] h = new int[len];
        
        for(int i=0; i<len; i++){
            int max = Math.max(sizes[i][0],sizes[i][1]);
            int min = Math.min(sizes[i][0],sizes[i][1]);

            w[i] = max;
            h[i] = min;
        }
        
        Arrays.sort(w);
        Arrays.sort(h);
        
        answer = w[len-1]*h[len-1];
        
        return answer;
    }
}