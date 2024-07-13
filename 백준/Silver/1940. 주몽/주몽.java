import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int start = 0, count = 0, end = N - 1;

		int[] numList = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numList);

		int sum = numList[start] + numList[end];

		while (start < end) {
			sum = numList[start] + numList[end];
			if (sum == M) {
				count++; start++; end--;
			} else if (sum > M) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(count);
	}
}