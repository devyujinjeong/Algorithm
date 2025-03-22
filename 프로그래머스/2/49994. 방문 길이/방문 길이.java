import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> path = new HashSet<>();
        int nowX = 5, nowY = 5;

        for (char temp : dirs.toCharArray()) {
            int nextX = nowX;
            int nextY = nowY;

            if (temp == 'U') {
                nextY++;
            } else if (temp == 'D') {
                nextY--;
            } else if (temp == 'L') {
                nextX--;
            } else if (temp == 'R') {
                nextX++;
            }

            if (nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10) {
                continue;
            }

            String path1 = nowX + "," + nowY + "," + nextX + "," + nextY;
            String path2 = nextX + "," + nextY + "," + nowX + "," + nowY;

            if (!path.contains(path1)) {
                path.add(path1);
                path.add(path2);
            }

            nowX = nextX;
            nowY = nextY;
        }

        return path.size() / 2;
    }
}
