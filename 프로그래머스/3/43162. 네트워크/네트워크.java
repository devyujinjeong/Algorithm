class Solution {
    static boolean[] visited;
    static int[][] computers;
    static int count;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        this.computers = computers; 
        count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { 
                count++;
                dfs(i, n);
            }
        }

        return count;
    }
    
    public static void dfs(int v, int n) {
        visited[v] = true;

        for (int i = 0; i < n; i++) {
            if (computers[v][i] == 1 && !visited[i]) {
                dfs(i, n);
            }
        }
    }
}
