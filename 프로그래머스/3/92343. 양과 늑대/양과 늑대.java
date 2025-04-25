import java.util.*;

class Solution {
    private static ArrayList<Integer>[] tree;
    private static int answer;

    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        answer = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.addAll(tree[0]);

        dfs(info, 1, 0, visited, nextNodes);

        return answer;
    }

    private void dfs(int[] info, int sheep, int wolf, boolean[] visited, List<Integer> nextNodes) {
        if (sheep <= wolf) return;
        answer = Math.max(answer, sheep);

        for (int i = 0; i < nextNodes.size(); i++) {
            int next = nextNodes.get(i);

            boolean[] visitedCopy = visited.clone();
            visitedCopy[next] = true;

            List<Integer> nextList = new ArrayList<>(nextNodes);
            nextList.remove(i);
            for (int child : tree[next]) {
                if (!visitedCopy[child]) nextList.add(child);
            }

            if (info[next] == 0) { // 양
                dfs(info, sheep + 1, wolf, visitedCopy, nextList);
            } else { // 늑대
                dfs(info, sheep, wolf + 1, visitedCopy, nextList);
            }
        }
    }
}
