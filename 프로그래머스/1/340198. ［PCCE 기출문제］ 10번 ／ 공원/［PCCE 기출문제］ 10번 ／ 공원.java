import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        Arrays.sort(mats);
        
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];

            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (park[x][y].equals("-1") && canPlaceMat(park, x, y, size)) {
                        return size; 
                    }
                }
            }
        }

        return -1; 
    }

    private boolean canPlaceMat(String[][] park, int x, int y, int size) {
        int rows = park.length;
        int cols = park[0].length;

        if (x + size > rows || y + size > cols) {return false;}

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) {return false;} 
            }
        }

        return true; 
    }
}
