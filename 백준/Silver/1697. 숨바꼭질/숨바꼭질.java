import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int time = cur[1];

            if (pos == K) return time;

            int[] next = {pos - 1, pos + 1, pos * 2};
            for (int nx : next) {
                if (nx >= 0 && nx <= 100000 && !visited[nx]) {
                    visited[nx] = true;
                    q.offer(new int[]{nx, time + 1});
                }
            }
        }
        return -1;
    }
}