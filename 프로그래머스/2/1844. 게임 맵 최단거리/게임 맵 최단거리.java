import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1}; 
    static int[] dy = {1, -1, 0, 0};
    static int[][] total;
    static int[][] maps;

    public int solution(int[][] maps) {
        int N = maps.length;      
        int M = maps[0].length;  
        this.maps = maps;

        total = new int[N][M];

        bfs(new Node(0, 0));

        return total[N - 1][M - 1] == 0 ? -1 : total[N - 1][M - 1];
    }

    static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        total[node.x][node.y] = 1; 

        int N = maps.length;
        int M = maps[0].length;

        while (!queue.isEmpty()) {
            Node temp = queue.poll(); 

            int nowX = temp.x;
            int nowY = temp.y;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i]; 

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (maps[nx][ny] == 1 && total[nx][ny] == 0) {
                        total[nx][ny] = total[nowX][nowY] + 1; 
                        queue.add(new Node(nx, ny)); 
                    }
                }
            }
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
