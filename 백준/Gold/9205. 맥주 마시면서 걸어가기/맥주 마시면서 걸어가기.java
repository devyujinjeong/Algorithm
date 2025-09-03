import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n+2][2]; // 출발지, 편의점, 축제 장소 기록
            visited = new boolean[n+2];

            for(int x=0; x<n+2; x++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int y=0; y<2; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(bfs()?"happy":"sad").append("\n");
        }

        System.out.println(sb);
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();

            // 축제 장소까지 바로 갈 수 있다면 가능한 경우 (q가 비는 동안 한번도 만족하지 못하면 가지 못한것)
            if(dist(temp, n+1) <= 1000) return true;

            for(int i=1; i<=n; i++) {
                if(!visited[i] && dist(temp, i) <=1000) { // 아직 방문하지 않았고, 거리도 1000안에 드는 경우
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        return false;
    }

    static int dist(int i, int j) {
        return Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1] - map[j][1]);
    }
}