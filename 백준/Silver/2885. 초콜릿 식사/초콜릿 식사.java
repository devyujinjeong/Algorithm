import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int D = 0; // 최소 조각
		int result = 0; // 쪼개는 횟수

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

		System.out.print(D + " " + result);

	}
}