class Solution {
    private int count = 0;
    private int n;
    private int[] queens; // 각 행에서 퀸이 놓인 열의 위치를 기록

    public int solution(int n) {
        this.n = n;
        queens = new int[n];
        backtrack(0);
        return count;
    }

    // 백트래킹을 구현한 함수
    private void backtrack(int x) {
        // x가 n이라면 퀸을 모두 배치 시킨 것
        if (x == n) {
            count++;
            return;
        }

        for (int y = 0; y < n; y++) {
            if (isPossible(x, y)) {
                // x행에서의 퀸의 위치는 y
                queens[x] = y;
                backtrack(x + 1);
            }
        }
    }

    // x행 y열에 퀸을 놓을 수 있는지 확인하기
    // 같은 열과 대각선에 퀸이 있는지 확인
    private boolean isPossible(int x, int y) {
        for (int i = 0; i < x; i++) {
            // 같은 열에 퀸이 있는지 확인
            if (queens[i] == y) return false; 
            // 대각선에 퀸이 있는지 확인
            if (Math.abs(x - i) == Math.abs(y - queens[i])) return false;
        }
        return true;
    }
}