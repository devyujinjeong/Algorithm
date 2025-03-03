import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int[][] keypad = {
            {3, 1}, // 0
            {0, 0}, {0, 1}, {0, 2}, // 1, 2, 3
            {1, 0}, {1, 1}, {1, 2}, // 4, 5, 6
            {2, 0}, {2, 1}, {2, 2}, // 7, 8, 9
            {3, 0}, {3, 2}  // *, #
        };

        int[] leftPos = keypad[10]; // '*' (왼손 위치)
        int[] rightPos = keypad[11]; // '#' (오른손 위치)

        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) { // 왼쪽 키패드
                answer += "L";
                leftPos = keypad[n];
            } else if (n == 3 || n == 6 || n == 9) { // 오른쪽 키패드
                answer += "R";
                rightPos = keypad[n];
            } else { // 중앙 키패드 (2, 5, 8, 0)
                int[] targetPos = keypad[n];

                int leftDist = Math.abs(leftPos[0] - targetPos[0]) + Math.abs(leftPos[1] - targetPos[1]);
                int rightDist = Math.abs(rightPos[0] - targetPos[0]) + Math.abs(rightPos[1] - targetPos[1]);

                if (leftDist < rightDist) {
                    answer += "L";
                    leftPos = targetPos;
                } else if (leftDist > rightDist) {
                    answer += "R";
                    rightPos = targetPos;
                } else { // 거리가 같다면 주 손잡이(hand) 결정
                    if (hand.equals("right")) {
                        answer += "R";
                        rightPos = targetPos;
                    } else {
                        answer += "L";
                        leftPos = targetPos;
                    }
                }
            }
        }
        return answer;
    }
}
