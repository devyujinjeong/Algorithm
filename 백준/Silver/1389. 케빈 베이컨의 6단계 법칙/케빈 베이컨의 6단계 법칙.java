import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int inf = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 유저의 수
		int M = Integer.parseInt(st.nextToken()); // 관계의 수

		int[][] D = new int[N][N];
		int[] result = new int[N];

		// 배열 초기화 하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					D[i][j] = 0;
				} else {
					D[i][j] = inf;
				}
			}
		}

		// 친구 관계 저장하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			D[s - 1][e - 1] = 1;
			D[e - 1][s - 1] = 1;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (D[i][k] != inf && D[k][j] != inf) {
						int update = Math.min(D[i][j], D[i][k] + D[k][j]);
						D[i][j] = update;
						D[j][i] = update; 
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i] += D[i][j];
			}
		}

		int min = result[0];
		int index = 0;
		for (int i = 1; i < N; i++) {
			if (min > result[i]) {
				min = result[i];
				index = i;
			}
		}

		System.out.println(index + 1); 
	}
}