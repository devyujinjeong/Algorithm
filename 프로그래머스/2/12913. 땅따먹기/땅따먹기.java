class Solution {
    int solution(int[][] land) {
        int n = land.length;
            
        for(int i=1; i<n; i++) {
            land[i][0] += findMax(land, i-1, 0);
            land[i][1] += findMax(land, i-1, 1);
            land[i][2] += findMax(land, i-1, 2);
            land[i][3] += findMax(land, i-1, 3);
        }  
        
        int answer = land[n-1][0];
        for(int i=1; i<4; i++) {
            if(answer < land[n-1][i]) {
                answer = land[n-1][i];
            }
        } 
        
        return answer;
    }
    
    private int findMax(int[][] land, int n, int j) {
        int max = 0;

        for(int i=0; i<4; i++) {
            if(i!=j && max < land[n][i]) {
                max = land[n][i];
            }
        }
        
        return max;
    } 
}