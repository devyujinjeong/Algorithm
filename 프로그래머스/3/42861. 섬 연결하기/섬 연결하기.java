import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        ArrayList<ArrayList<Island>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            graph.get(a).add(new Island(b, c));
            graph.get(b).add(new Island(a, c));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Island> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        // 임의의 시작점 (0번 섬)
        pq.offer(new Island(0, 0));

        while (!pq.isEmpty()) {
            Island now = pq.poll();

            if (visited[now.node]) continue;
            visited[now.node] = true;
            answer += now.cost;

            for (Island next : graph.get(now.node)) {
                if (!visited[next.node]) {
                    pq.offer(next);
                }
            }
        }

        return answer;
    }
}

class Island {
    int node;
    int cost;

    public Island(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
