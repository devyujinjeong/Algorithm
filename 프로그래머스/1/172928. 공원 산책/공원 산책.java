class Solution {
    public int[] solution(String[] park, String[] routes) {
        int row = park.length;
        int col = park[0].length();
        int[] answer = new int[2];

        boolean found = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        for (String route : routes) {
            char dir = route.charAt(0);
            int move = route.charAt(2) - '0';

            int nx = answer[0];
            int ny = answer[1];
            boolean canMove = true;

            for (int j = 0; j < move; j++) {
                if (dir == 'E') ny++;
                else if (dir == 'W') ny--;
                else if (dir == 'S') nx++;
                else if (dir == 'N') nx--;

                // 범위를 벗어나거나 장애물이 있는 경우 이동 불가
                if (nx < 0 || nx >= row || ny < 0 || ny >= col || park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }

            // 이동 가능하면 최종 위치 업데이트
            if (canMove) {
                answer[0] = nx;
                answer[1] = ny;
            }
        }

        System.out.println("최종 위치: " + answer[0] + ", " + answer[1]);
        return answer;
    }
}
