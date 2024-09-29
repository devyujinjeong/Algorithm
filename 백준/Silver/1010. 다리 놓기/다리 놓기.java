import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[][] C = new int[31][31];

		for (int i = 0; i <= 30; i++) {
			C[i][i] = 1;
			C[i][0] = 1;
			C[i][1] = i;
		}

		for (int i = 2; i <= 30; i++) {
			for (int j = 1; j < i; j++) {
				C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}

		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(C[M][N]+"\n");
		}
		
		System.out.println(sb);
	}
}
