import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] home = new int[N+1][4];
        int[][] dp = new int[N+1][4];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            home[i][1] = Integer.parseInt(st.nextToken());
            home[i][2] = Integer.parseInt(st.nextToken());
            home[i][3] = Integer.parseInt(st.nextToken());
        }

        dp[1][1] = home[1][1];
        dp[1][2] = home[1][2];
        dp[1][3] = home[1][3];

        for(int i=2; i<=N; i++){
            dp[i][1] = home[i][1] + Math.min(dp[i-1][2], dp[i-1][3]);
            dp[i][2] = home[i][2] + Math.min(dp[i-1][1], dp[i-1][3]);
            dp[i][3] = home[i][3] + Math.min(dp[i-1][1], dp[i-1][2]);
        }

        int answer = Math.min(dp[N][1], Math.min(dp[N][2], dp[N][3]));
        System.out.println(answer);
    }
}
