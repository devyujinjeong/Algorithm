class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int len = sizes.length;
        int w = 0;
        int h = 0;

        for(int i=0; i<len; i++){
            int max = Math.max(sizes[i][0],sizes[i][1]);
            int min = Math.min(sizes[i][0],sizes[i][1]);
            
            w = Math.max(w,max);
            h = Math.max(h,min);
;
        }
        
        answer = w*h;
        
        return answer;
    }
}