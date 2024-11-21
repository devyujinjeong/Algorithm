import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] prices;

	static int calculatePrice(int a, int b) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] classes = new int[a];

		for (int i = 0; i < a; i++) {
			classes[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(classes);

		if (a < b) {
			return 1;
		} else {
			return classes[a - b];
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 0;
		prices = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			prices[i] = calculatePrice(a, b);
		}

		Arrays.sort(prices);

		for (int i = 0; i < n; i++) {
			if (m - prices[i] >= 0) {
				m -= prices[i];
				count++;
			}else {
				break;
			}
		}
		System.out.println(count);

	}
}