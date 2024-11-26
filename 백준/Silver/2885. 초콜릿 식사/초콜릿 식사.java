import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = Integer.parseInt(br.readLine());
		int D = 0;
		int result = 0;

		int a = k;
		while (a > 1) {
			a = a / 2;
			D++;
		}

		int num = (int) Math.pow(2, D);
		D = num == k ? k : num * 2;
		int b = D / 2;

		if (num == k) {
			result = 0;
		} else {
			while (b != 0 && k != 0) {
				if (b <= k) {
					k -= b;
				}
				result++;
				b = b / 2;
			}
		}

		bw.write(D + " " + result);
		bw.flush();
		bw.close();
	}
}
