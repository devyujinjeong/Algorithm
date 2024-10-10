import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] h = new int[n + 1]; // 계단의 높이를 저장하는 배열
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			h[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = h[1];
		
		if(n>=2) {
			dp[2] = h[1]+h[2];
		}
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + h[i - 1])+h[i];
		}
		
		System.out.println(dp[n]);

	}
}