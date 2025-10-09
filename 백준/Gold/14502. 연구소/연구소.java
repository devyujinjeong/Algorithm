import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] center;
    static ArrayList<int[][]> arr;
    static int N, M, max;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        center = new int[N][M]; // 연구소의 크기 설정하기
        arr = new ArrayList<>();

        // 연구소 만들기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                center[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findWall(center, 0, 0);

        for(int[][] temp : arr) {
            int regin = findMax(temp);
            if(regin>max) max = regin;
        }

        System.out.println(max);
    }

    static void findWall(int[][] cur, int depth, int start) {
        if (depth == 3) {
            int[][] copy = new int[N][M];
            for (int i = 0; i < N; i++) copy[i] = cur[i].clone(); // 깊은 복사
            arr.add(copy);
            return;
        }

        for (int k = start; k < N * M; k++) {   // 조합(중복 방지)
            int i = k / M;
            int j = k % M;
            if (cur[i][j] == 0) {
                cur[i][j] = 1;
                findWall(cur, depth + 1, k + 1); // 다음 칸부터
                cur[i][j] = 0;
            }
        }
    }

    static int findMax(int[][] region) {
        Queue<Node> q = new LinkedList<>();
        int count = 0;

        // 바이러스가 있는 부분을 q에 넣기
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(region[i][j] == 2) q.add(new Node(i,j));
            }
        }

        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue; // 범위를 벗어난다면 pass

                if(region[nx][ny] != 0) continue; // 0이 아니면 pass

                region[nx][ny] = 2; // 바이러스 전염 시키기 : 0인 부분을 2로 바꾸기
                q.add(new Node(nx, ny));

            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(region[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}