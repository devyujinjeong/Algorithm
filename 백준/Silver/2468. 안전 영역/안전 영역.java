import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] area; // 지역별 물 높이를 저장하는 2차원 배열
    static boolean[][] visited; // 방문을 확인할 2차원 배열
    static int N;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    static void DFS(int h, int x, int y) { // 물의 높이와 x,y 좌표
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int wx = x + dx[i];
            int wy = y + dy[i];

            if (wx < 0 || wy < 0 || wx >= N || wy >= N) {
                continue;
            }
            
            if (!visited[wx][wy] && area[wx][wy] > h) {
                visited[wx][wy] = true;
                DFS(h, wx, wy);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        area = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] > max) {
                    max = area[i][j]; // 최대 높이 확인하기
                }
            }
        }

        int answer = 0;
        for (int h = 0; h < max; h++) {
            visited = new boolean[N][N]; // 각 높이 별로 매번 새 배열 생성
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && area[i][j] > h) {
                        count++;
                        DFS(h, i, j);
                    }
                }
            }
            
            if (answer < count) {
                answer = count;
            }
        }
        
        System.out.println(answer);
    }
}
