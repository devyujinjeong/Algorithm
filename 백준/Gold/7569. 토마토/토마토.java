import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static int[] dx = {0,0,0,0,1,-1};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {1,-1,0,0,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for(int k = 0; k<H; k++) {
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();

        int answer = 0;
        for(int k = 0; k<H; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(box[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    answer = Math.max(answer, box[k][i][j]);
                }
            }
        }

        System.out.println(answer - 1);
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();

        for(int k = 0; k<H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[k][i][j] == 1) {
                        q.add(new Node(i, j, k));
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            Node temp = q.poll();

            for(int i=0; i<6; i++) {
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];
                int nextZ = temp.z + dz[i];

                if(nextX<0 || nextX>=N || nextY<0 || nextY>=M || nextZ<0 || nextZ>=H) continue;

                if(box[nextZ][nextX][nextY] != 0) continue;

                q.add(new Node(nextX, nextY, nextZ));
                box[nextZ][nextX][nextY] =  box[temp.z][temp.x][temp.y] + 1;
            }
        }
    }
}

class Node{
    int x;
    int y;
    int z;

    public Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}