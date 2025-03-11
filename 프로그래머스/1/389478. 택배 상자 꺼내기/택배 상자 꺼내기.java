class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = (n % w == 0) ? n / w : n / w + 1;
        
        int[][] arr = new int[row][w];
        int idx1 = 0;
        int idx2 = 0;

        int value = 1;
        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) { 
                for (int j = 0; j < w; j++) {
                    if (value > n) break;
                    arr[i][j] = value++;
                    if (arr[i][j] == num) {
                        idx1 = i;
                        idx2 = j;
                    }
                }
            } else { 
                for (int j = w - 1; j >= 0; j--) {
                    if (value > n) break;
                    arr[i][j] = value++;
                    if (arr[i][j] == num) {
                        idx1 = i;
                        idx2 = j;
                    }
                }
            }
        }


        for (int i = idx1; i < row; i++) {
            if (i % 2 == 0) {
                if (arr[i][idx2] != 0) {
                    answer++;
                }
            } else {
                if (arr[i][idx2] != 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
