import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;

	static void DFS(int number, int digit) {
		// 만약 자리수가 n과 같을 경우에 prime인지 확인하고 종료하기
		if (digit == n) {
			if (checkPrime(number)) {
				System.out.println(number);
				return;
			}
		}

		for (int i = 1; i < 10; i++) {
			if (i % 2 == 1 && checkPrime(number)) {
				DFS(number * 10 + i, digit + 1);
			}
		}

	}

	// 소수 체크 메소드
	static boolean checkPrime(int prime) {
		for (int i = 2; i <= prime / 2; i++) {
			if (prime % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		// 2,3,5,7만 맨 앞으로 올 수 있음
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
}