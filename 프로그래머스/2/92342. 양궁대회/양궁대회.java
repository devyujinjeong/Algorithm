import java.util.*;

class Solution {
    private static int max;
    private static int[] answer;
    private static int[] apeach;

    private static int getScore(int[] ryan) {
        int score = 0;
        for (int i = 0; i <= 10; i++) {
            if (ryan[i] + apeach[i] > 0) {
                score += (ryan[i] > apeach[i]) ? (10 - i) : -(10 - i);
            }
        }
        return score;
    }

    private static void calculateDiff(int[] ryan) {
        int score = getScore(ryan);
        if (max < score) {
            max = score;
            answer = ryan.clone();
        } else if (max > 0 && max == score) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] != ryan[i]) {
                    if (answer[i] < ryan[i]) {
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }

    private static void backtracking(int n, int idx, int[] ryan) {
        if (idx == 11 || n == 0) {
            if (n > 0) ryan[10] += n; // 남은 화살 몰아주기
            calculateDiff(ryan);
            if (n > 0) ryan[10] -= n;
            return;
        }

        // 이 점수에 이기도록 쏘는 경우
        if (n > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            backtracking(n - ryan[idx], idx + 1, ryan);
            ryan[idx] = 0;
        }

        // 이 점수를 포기하고 넘어가는 경우
        backtracking(n, idx + 1, ryan);
    }

    public int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        answer = new int[]{-1};
        backtracking(n, 0, new int[11]);
        return answer;
    }
}
