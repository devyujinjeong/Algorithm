class Solution {
    static int[][] computers;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, n);
                answer++;
            }
            
        }
        
        return answer;
    }
    
    static void dfs(int v, int n){
        visited[v] = true;

        for (int i = 0; i < n; i++) {
            if (computers[v][i] == 1 && !visited[i]) {
                dfs(i, n);
            }
        }
    }
}