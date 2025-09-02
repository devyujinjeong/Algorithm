import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M,N;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                answer = Math.max(answer, map[i][j]);
            }
        }

        System.out.println(answer-1);
    }

    static void bfs() {
        Queue<Node1> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 1) q.add(new Node1(i,j)); // 익은 토마토를 넣기
            }
        }

        while(!q.isEmpty()) {
            Node1 temp = q.poll();

            for(int i=0; i<4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx<0 || nx >=N || ny<0 || ny>=M) continue;

                if(map[nx][ny]!=0) continue;

                q.add(new Node1(nx, ny));
                map[nx][ny] = map[temp.x][temp.y] + 1;
            }
        }
    }
}

class Node1 {
    int x;
    int y;

    public Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }

}