import java.util.*;

class Solution {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int N;
    static int[][][] cost;

    public int solution(int[][] board) {
        N = board.length;
        cost = new int[N][N][4]; // 각 위치별, 방향별 최소 비용

        for (int[][] layer : cost) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        bfs(board);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[N - 1][N - 1][i]);
        }

        return answer;
    }

    static void bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, -1, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!isValid(nx, ny, board)) continue;

                int newCost = cur.cost;
                if (cur.direction == -1 || cur.direction == i) {
                    newCost += 100; // 직선
                } else {
                    newCost += 600; // 커브
                }

                if (cost[nx][ny][i] > newCost) {
                    cost[nx][ny][i] = newCost;
                    q.offer(new Node(nx, ny, i, newCost));
                }
            }
        }
    }

    static boolean isValid(int x, int y, int[][] board) {
        return x >= 0 && y >= 0 && x < N && y < N && board[x][y] == 0;
    }
}

class Node {
    int x, y, direction, cost;

    public Node(int x, int y, int direction, int cost) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.cost = cost;
    }
}
