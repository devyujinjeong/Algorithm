import java.util.*;

class Solution {
    static int maxCount;

    public int solution(int k, int[][] dungeons) {
        maxCount = 0;
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return maxCount;
    }

    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            int required = dungeons[i][0];
            int consume = dungeons[i][1];

            if (!visited[i] && k >= required) {
                visited[i] = true;
                dfs(k - consume, dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
        maxCount = Math.max(maxCount, count);
    }

}