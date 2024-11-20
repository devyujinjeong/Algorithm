import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int result = 0;

		int[] kayak = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			kayak[i] = 1;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			int k = Integer.parseInt(st.nextToken());
			kayak[k] -= 1;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int k = Integer.parseInt(st.nextToken());
			kayak[k] += 1;
		}

		for (int i = 1; i <= N; i++) {
			if (i > 1 && kayak[i] == 0 && kayak[i - 1] == 2) {
				kayak[i] = 1;
				kayak[i - 1] = 1;
			} else if (i < N && kayak[i] == 0 && kayak[i + 1] == 2) {
				kayak[i] = 1;
				kayak[i + 1] = 1;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (kayak[i] == 0) {
				result++;
			}
		}
		System.out.println(result);
	}
}
