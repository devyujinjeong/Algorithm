import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] dp;
    static int[] r;
    static int[] c;

    static int getMin(int s, int e) {
        int result = Integer.MAX_VALUE;

        if (dp[s][e] != -1) {
            return dp[s][e];
        }

        if (s == e) { // 행렬이 1개인 경우 연산 횟수
            return 0;
        } else if (s + 1 == e) { // 행렬이 2개인 경우 연산 횟수
            return r[s] * c[s] * c[e];
        } else { // 행렬이 3개 이상인 경우
            for (int i = s; i < e; i++) {
                result = Math.min(result, getMin(s, i) + getMin(i + 1, e) + r[s] * c[i] * c[e]);
            }
        }

        return dp[s][e] = result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        r = new int[N + 1];
        c = new int[N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(getMin(1, N));
    }
}