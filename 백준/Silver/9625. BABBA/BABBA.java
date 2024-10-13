import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] count = new int[N + 1][2]; // A와 B를 count한 값을 저장한 배열

		count[1][0] = 0;
		count[1][1] = 1;

		for (int i = 2; i <= N; i++) {
			count[i][0] = count[i - 1][1];
			count[i][1] = count[i - 1][0] + count[i - 1][1];
		}

		System.out.println(count[N][0] + " " + count[N][1]);
	}
}