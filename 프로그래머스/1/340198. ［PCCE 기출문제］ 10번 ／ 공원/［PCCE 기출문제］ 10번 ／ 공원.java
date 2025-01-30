import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        // 돗자리 크기를 큰 것부터 확인하기 위해 내림차순 정렬
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];

            // 공원 전체를 탐색하며 돗자리를 놓을 수 있는지 확인
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (park[x][y].equals("-1") && canPlaceMat(park, x, y, size)) {
                        return size; // 가장 큰 돗자리 크기를 찾으면 바로 반환
                    }
                }
            }
        }

        return -1; // 놓을 수 있는 돗자리가 없음
    }

    // 특정 위치 (x, y)에서 size x size 크기의 돗자리를 놓을 수 있는지 확인하는 함수
    private boolean canPlaceMat(String[][] park, int x, int y, int size) {
        int rows = park.length;
        int cols = park[0].length;

        // 돗자리가 공원 범위를 벗어나면 불가능
        if (x + size > rows || y + size > cols) {return false;}

        // size x size 영역이 모두 "-1"인지 검사
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) return false; // 사람이 있는 자리라면 불가능
            }
        }

        return true; // 돗자리를 놓을 수 있음
    }
}
