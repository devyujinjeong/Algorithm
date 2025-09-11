import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,L,R;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        // 가능한 경우가 1개라도 있을 때까지 진행
        while(true) {
            int count = 0;
            visited = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        bfs(i,j);
                        count++; // 만약 count와 N이 같으면 어느 곳이든 방문할 수 없으므로 finish
                    }
                }
            }

            if(count == N*N)  break;

            answer++;
        }

        System.out.println(answer);
    }

    static void bfs(int i, int j) {
        Queue<Node> q1 = new LinkedList<>(); // 인접한 지역을 찾기 위한 queue
        Queue<Node> q2 = new LinkedList<>(); // 인구수 계산을 위한 queue
        q1.add(new Node(i,j));
        q2.add(new Node(i,j));
        visited[i][j] = true;

        int sum = A[i][j];
        int count = 1;
        while(!q1.isEmpty()) {
            Node temp = q1.poll();
            for(int k = 0; k<4; k++) {
                int nx = temp.x + dx[k];
                int ny = temp.y + dy[k];

                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;

                if(visited[nx][ny]) continue;

                int diff = Math.abs(A[temp.x][temp.y]-A[nx][ny]);
                if(diff<L || diff>R) continue;


                visited[nx][ny] = true;
                sum+= A[nx][ny];
                count++;

                q1.add(new Node(nx, ny));
                q2.add(new Node(nx, ny));
            }
        }

        for(Node n : q2) {
            A[n.x][n.y] = sum/count;
        }
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