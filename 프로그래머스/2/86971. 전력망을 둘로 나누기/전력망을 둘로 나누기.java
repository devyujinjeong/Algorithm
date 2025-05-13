import java.util.*;

class Solution {
    private ArrayList<Integer>[] tree;
    private boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        
        // 차이의 최대값은 n
        int minDiff = n; 
        
        // 각 전선 끊어보기
        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            int count = dfs(wire[0], wire[1]); // v1에서 v2 제외하고 노드 세기
            int diff = Math.abs(count - (n - count)); // 차이 계산
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
    
    private int dfs(int node, int exclude) {
        visited[node] = true;
        int count = 1; // 현재 노드
        for (int next : tree[node]) {
            if (!visited[next] && next != exclude) {
                count += dfs(next, exclude);
            }
        }
        return count;
    }
}