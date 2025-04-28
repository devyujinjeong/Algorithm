import java.util.*;

class Solution {

    // 동서남북 경로를 위한 배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        int answer = 0;

        int N = maps.length;
        int M = maps[0].length;

        // 최단 거리를 저장할 배열 
        int[][] dist = new int[N][M];

        ArrayDeque<Node> queue = new ArrayDeque<>();

        // 시작점을 큐에 넣고 거리는 1로 초기화
        queue.addLast(new Node(0, 0));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];

                // 맵을 벗어나는 경우
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                // 벽인 곳은 건너뛰기
                if (maps[nr][nc] == 0) continue;

                // 아직 방문하지 않은 곳만 큐에 넣고 거리 업데이트
                if (dist[nr][nc] == 0) {
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }

        // BFS를 통해 최단 거리 계산하기
        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }
}

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
