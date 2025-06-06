import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        backtrack(0, new StringBuilder());

        System.out.print(sb); // 한 번에 출력
    }

    static void backtrack(int depth, StringBuilder current) {
        if (depth == M) {
            sb.append(current).append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int len = current.length();
                current.append(i).append(" ");
                backtrack(depth + 1, current);
                current.setLength(len); 
                visited[i] = false;
            }
        }
    }
}
