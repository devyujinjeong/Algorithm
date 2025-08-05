import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int mod = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int[][] dp = new int[N+1][10]; // dp[i][j] = i자리 수 중 j로 끝나는 수의 개수

        for(int i=1; i<=N; i++) {
            dp[i][0] = 1;
        }

        for(int j=1; j<10; j++){
            dp[1][j] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j = 1; j<=9; j++) {
                dp[i][j] = (dp[i-1][j] % mod + dp[i][j-1] % mod) % mod;
            }
        }

        for(int j=0; j<10; j++) {
            answer += dp[N][j];
        }

        System.out.println(answer % mod);
    }
}
