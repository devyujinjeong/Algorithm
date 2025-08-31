import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int count = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1) {
                    answer.add(bfs(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);

        Collections.sort(answer);
        for(int size : answer) {
            sb.append(size).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i,j));
        map[i][j] = 0;

        int size = 1;
        while(!q.isEmpty()){
            Node temp = q.poll();
            int tempX = temp.x;
            int tempY = temp.y;

            for(int k=0; k<4; k++) {
                int nextX = tempX + dx[k];
                int nextY = tempY + dy[k];

                if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;

                if(map[nextX][nextY] == 0) continue;

                q.add(new Node(nextX, nextY));
                map[nextX][nextY] = 0;

                size++;
            }
        }

        return size;
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