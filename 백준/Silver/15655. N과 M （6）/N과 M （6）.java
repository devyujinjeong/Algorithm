import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] num;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        backtracking(0,  0, new StringBuilder());

        System.out.println(sb);
    }

    static void backtracking(int depth, int start, StringBuilder cur) {
        if(depth == M) {
            sb.append(cur).append("\n");
            return;
        }

        for(int i=start; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int len = cur.length();
                cur.append(num[i]).append(" ");
                backtracking(depth+1, i+1, cur);
                cur.setLength(len);
                visited[i] = false;
            }
        }
    }
}