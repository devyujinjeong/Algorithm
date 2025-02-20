import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] path = new int[N + 1]; // 경로 추적 배열

        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;

            // 2로 나누어 떨어질 때
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }

            // 3으로 나누어 떨어질 때
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }

            // 6으로 나누어 떨어지는 경우 (2와 3 둘 다 나누어 떨어짐)
            if (i % 6 == 0) {
                int minOp = Math.min(Math.min(dp[i / 2], dp[i / 3]), dp[i - 1]);
                if (dp[i] > minOp + 1) {
                    dp[i] = minOp + 1;

                    if (minOp == dp[i / 2]) {
                        path[i] = i / 2;
                    } else if (minOp == dp[i / 3]) {
                        path[i] = i / 3;
                    } else {
                        path[i] = i - 1;
                    }
                }
            }
        }

        System.out.println(dp[N]);

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            sb.append(N).append(" ");
            N = path[N]; 
        }
        System.out.println(sb);
    }
}