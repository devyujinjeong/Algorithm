class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int[][] d = {{0,1,2,3}, {0,2,1,3}, {0,3,1,2}};
        
        for (int i = 0; i < 3; i++) {       
            int x1 = dots[d[i][0]][0] - dots[d[i][1]][0];
            int y1 = dots[d[i][0]][1] - dots[d[i][1]][1];

            int x2 = dots[d[i][2]][0] - dots[d[i][3]][0];
            int y2 = dots[d[i][2]][1] - dots[d[i][3]][1];

            if (x1 != 0 && x2 != 0) {
                double slope1 = (double) y1 / x1;
                double slope2 = (double) y2 / x2;
                
                if (slope1 == slope2) {
                    answer = 1;
                    break;
                }   
            }
        }

        return answer;
    }
}
