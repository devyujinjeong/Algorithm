import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Node[] position;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            position = new Node[n+2];
            visited = new boolean[n+2];
            for(int j=0; j<n+2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                position[j] = new Node(x,y);
            }

            sb.append(bfs(position, n)).append("\n");
        }

        System.out.println(sb);
    }

    static String bfs(Node[] position, int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(position[0]);
        visited[0] = true;

        while(!q.isEmpty()) {
            Node temp = q.poll();

            // 현재 위치와 페스티벌 위치가 1000이하면 갈 수 있으므로 happy 출력
            if(findDistance(temp, position[n+1]) <= 1000) return "happy";

            for(int i=1; i<n+1; i++) {
                // 현재 위치에서 다음 편의점까지 갈 수 없으면 패스
                if(findDistance(temp, position[i]) > 1000) continue;

                if(visited[i]) continue;

                q.add(position[i]);
                visited[i] = true;
            }
        }

        return "sad";
    }

    /* 거리 계산 */
    static int findDistance(Node n1, Node n2) {
        int x = Math.abs(n1.x - n2.x);
        int y = Math.abs(n1.y - n2.y);

        return x+y;
    }

    /* 위치를 저장하기 위한 Node */
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}