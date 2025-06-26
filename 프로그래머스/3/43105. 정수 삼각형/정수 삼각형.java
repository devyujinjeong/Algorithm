import java.util.*;

class Solution {
    public int solution(int[][] triangle) {        
        for(int i = triangle.length-2; i>=0; i--) {
            for(int j = triangle[i].length-1; j>=0; j--) {
                int num1 = triangle[i][j] + triangle[i+1][j];
                int num2 = triangle[i][j] + triangle[i+1][j+1];

                triangle[i][j] = Math.max(num1, num2);                    
            }
        }
        
        return triangle[0][0];
    }
}