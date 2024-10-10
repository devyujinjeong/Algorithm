import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] p = { { 0, 2, 2, 2, 2 }, { 2, 1, 3, 4, 3 }, { 2, 3, 1, 3, 4 }, { 2, 4, 3, 1, 3 }, { 2, 3, 4, 3, 1 } };
		int[][][] DP = new int[100001][5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 100001; k++) {
					DP[k][i][j] = 100001*4;
				}
			}
		}

		DP[0][0][0] = 0;

		int s = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (true) {
			int n = Integer.parseInt(st.nextToken());

			if (n == 0) {
				break;
			}

			for (int i = 0; i < 5; i++) {
				// 두 발이 같은 자리에 있을 수 없음
				if (n == i) {
					continue;
				}

				for (int j = 0; j < 5; j++) {
					DP[s][i][n] = Math.min(DP[s - 1][i][j] + p[j][n], DP[s][i][n]);
				}
			}

			for (int j = 0; j < 5; j++) {
				// 두 발이 같은 자리에 있을 수 없음
				if (n == j) {
					continue;
				}

				for (int i = 0; i < 5; i++) {
					DP[s][n][j] = Math.min(DP[s - 1][i][j] + p[i][n], DP[s][n][j]);
				}
			}

			s++;
		}
		s--;
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				min = Math.min(min, DP[s][i][j]); 
			}
		}
		System.out.println(min);
	}
}
