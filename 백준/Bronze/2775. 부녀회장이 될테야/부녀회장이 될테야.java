import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[][] D = new int[15][15];

		for (int i = 0; i <= 14; i++) {
			D[i][1] = 1;
			D[0][i] = i;
		}

		for (int i = 1; i <= 14; i++) {
			for (int j = 2; j <= 14; j++) {
				D[i][j] = D[i][j - 1] + D[i - 1][j];
			}
		}

		for (int i = 0; i < T; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			System.out.println(D[a][b]);
		}
	}
}
