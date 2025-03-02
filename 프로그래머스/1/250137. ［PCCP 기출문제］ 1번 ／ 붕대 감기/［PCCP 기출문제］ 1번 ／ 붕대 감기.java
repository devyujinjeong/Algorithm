class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int count = 0;
        int j = 0;

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (i == attacks[j][0]) { // 공격받는 시간
                answer -= attacks[j++][1];
                count = 0;
            } else { // 회복 시간
                answer = Math.min(health, answer + bandage[1]); // 최대 체력 초과 방지
                if (++count == bandage[0]) { // 연속 시전 성공
                    answer = Math.min(health, answer + bandage[2]);
                    count = 0;
                }
            }
            if (answer <= 0) return -1;
        }
        return answer;
    }
}
