import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static long MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int height = 0;
		int length = N;

		while (length != 0) {
			length /= 2;
			height++;
		}

		int size = (int) Math.pow(2, height + 1);
		int start = size / 2 - 1;

		tree = new long[size + 1];
		Arrays.fill(tree, 1); // 곱하기이므로 tree배열의 값을 모두 1로 채우기
		for (int i = start + 1; i <= start + N; i++) {
			tree[i] = Long.parseLong(br.readLine()); // 처음에 주어진 값 tree에 저장하기
		}

		setTree(size - 1); // 트리 만들기

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			b = b + start; // 인덱스 번호 맞추기
			if (a == 1) { // 숫자 바꾸기
				changeNum(b, c);
			} else if (a == 2) { // a=2인 경우엔 b와 c 범위의 구간합을 구하기
				c = c + start; // 인덱스 번호 맞추기
				sb.append(multiply(b, c)).append('\n');
			}
		}
		System.out.println(sb);
	}

	static void setTree(int i) {
		while (i != 1) {
			tree[i / 2] = tree[i / 2] * tree[i] % MOD;
			i--;
		}
	}

	static long multiply(int s, int e) {
		long multi = 1;
		while (s <= e) {
			if (s % 2 == 1) {
				multi = multi * tree[s] % MOD;
				s++;
			}

			if (e % 2 == 0) {
				multi = multi * tree[e] % MOD;
				e--;
			}
			s = s / 2;
			e = e / 2;
		}

		return multi;
	}

	static void changeNum(int index, int value) { // 값을 변경 후에 트리 구조 다시 업데이트 하기
		tree[index] = value;
		while (index > 1) {
			index = index / 2;
			tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
		}
	}
}
