import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		long[] p = new long[101];

		for(int i=1; i<=3; i++) {
			p[i] = 1;
		}

		p[4] = 2;
		p[5] = 2;

		for (int i = 6; i <= 100; i++) {
			p[i] = p[i - 1] + p[i - 5];
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(p[N] + "\n");
		}

		System.out.println(sb);
	}
}