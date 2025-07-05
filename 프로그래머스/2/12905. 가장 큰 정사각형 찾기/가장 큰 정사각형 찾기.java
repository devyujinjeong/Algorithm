import java.util.*;
class Solution {
    public int solution(int[][] board) {    
        int x = board.length;
        int y = board[0].length;
        
        int maxLen = 0;
        
        if (x == 1 || y == 1) {
            for (int[] b : board) {
                for (int val : b) {
                    if (val == 1) return 1;
                }
            }
            return 0;
        }
        
        for(int i=1; i<x; i++) {
            for(int j=1; j<y; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = Math.min(
                        Math.min(board[i-1][j], board[i][j-1]),
                        board[i-1][j-1]
                    ) + 1;
                }
                
                maxLen = Math.max(maxLen, board[i][j]);
            }
        }
        
        return maxLen*maxLen;
    }
}