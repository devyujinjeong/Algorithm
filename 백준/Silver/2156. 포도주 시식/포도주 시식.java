import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = num[1];

        for(int i=2; i<=N; i++) {
            if(i==2) {
                dp[i] = num[1] + num[2];
            } else {
                // 1. dp[i-1]
                // 2. 2칸 전의 값(dp[i-2])과 현재 값(num[i]) 더하기
                // 3. 3칸 전의 답(dp[i-3] + 현재와 이전의 값 (num[i-1] + num[i])
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + num[i], dp[i-3] + num[i-1] + num[i]));
            }
        }

        System.out.println(dp[N]);
    }
}
