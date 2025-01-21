import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		long mod = 1000000009;
		long[][] sum = new long[4][100001];

		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				if (i == j || j == 3) {
					sum[i][j] = 1;
				} else {
					sum[i][j] = 0;
				}
			}
		}

		for (int i = 4; i < 100001; i++) {
			sum[1][i] = (sum[2][i - 1] + sum[3][i - 1]) % mod;
			sum[2][i] = (sum[1][i - 2] + sum[3][i - 2]) % mod;
			sum[3][i] = (sum[1][i - 3] + sum[2][i - 3]) % mod;
		}

		for (int i = 0; i < T; i++) {
			int a = Integer.parseInt(br.readLine());
			long result = (sum[1][a] + sum[2][a] + sum[3][a]) % mod;
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}