import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtracking(0, new StringBuilder());

        System.out.println(sb);
    }

    static void backtracking(int depth, StringBuilder cur){
        if(depth == M) {
            sb.append(cur).append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            int len = cur.length();
            cur.append(i).append(" ");
            backtracking(depth+1, cur);
            cur.setLength(len);
        }
    }
}
