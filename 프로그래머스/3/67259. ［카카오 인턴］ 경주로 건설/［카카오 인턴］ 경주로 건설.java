import java.util.*;

class Solution {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int N;
    static int[][][] cost;
    static int[][] board;

    public int solution(int[][] board) {
        this.board = board;
        N = board.length;
        // 위치별, 방향별 최소 비용 (방향이 4개 이므로)
        cost = new int[N][N][4];

        for (int[][] layer : cost) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        bfs();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[N - 1][N - 1][i]);
        }

        return answer;
    }

    static void bfs() {
        PriorityQueue<Node> pq = 
            new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        
        // 첫 시작점은 방향이 없으니깐 -1로 설정
        pq.offer(new Node(0, 0, -1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!isValid(nx, ny)) continue;

                int newCost = cur.cost;
                if (cur.direction == -1 || cur.direction == i) {
                    newCost += 100; // 직선
                } else {
                    newCost += 600; // 커브 (방향이 달라짐)
                }

                if (cost[nx][ny][i] > newCost) {
                    cost[nx][ny][i] = newCost;
                    pq.offer(new Node(nx, ny, i, newCost));
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
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
