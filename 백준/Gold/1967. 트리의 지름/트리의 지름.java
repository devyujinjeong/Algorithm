import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, max, far;
    static ArrayList<Node>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 정보 입력하기
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 부모 노드
            int c = Integer.parseInt(st.nextToken()); // 자식 노드
            int dist = Integer.parseInt(st.nextToken()); // 거리

            tree[p].add(new Node(c, dist));
            tree[c].add(new Node(p, dist));
        }

        // 1차 DFS: 1에서 가장 먼 정점 far 찾기
        Arrays.fill(visited, false);
        max = 0;
        far = 1;
        dfs(1, 0);

        // 2차 DFS: far에서 시작해 지름 계산
        Arrays.fill(visited, false);
        max = 0;
        dfs(far, 0);

        System.out.println(max);
    }

    // 객체 생성 없이 정수 인자만 사용 (메모리 절약)
    static void dfs(int cur, int dist) {
        visited[cur] = true;

        if (dist > max) {
            max = dist;
            far = cur;
        }

        for (Node next : tree[cur]) {
            if (!visited[next.point]) {
                dfs(next.point, dist + next.dist);
            }
        }
    }

    static class Node {
        int point; // 위치
        int dist;  // 거리

        public Node(int point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }
}