import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[1005001];
		int M = num.length - 1;

		for (int i = 2; i <= M; i++) {
			num[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(M); i++) {
			if (num[i] == 0) {
				continue;
			}

			for (int j = i + i; j <= M; j = j + i) {
				num[j] = 0;
			}
		}

		int i = N;
		while (true) {
			if (num[i] != 0) {
				int result = num[i];
				if (isPalindrome(result)) {
					System.out.println(result);
					break;
				}
			}
			i++;
		}
	}

	static boolean isPalindrome(int find) {
		char[] c = String.valueOf(find).toCharArray();

		int start = 0;
		int end = c.length - 1;

		while (start < end) {
			if (c[start] != c[end]) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}
}