import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static Long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int height = 0;
		int length = N;

		while (length != 0) {
			length /= 2;
			height++;
		}

		int size = (int) Math.pow(2, height + 1);
		int start = size / 2 - 1;

		tree = new Long[size];
        Arrays.fill(tree, Long.MAX_VALUE);

		for (int i = start + 1; i <= start + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}

		setTree(size - 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			s = s + start;
			e = e + start;
			
			sb.append(getMin(s,e)).append("\n");
		}
		System.out.println(sb);
	}

	static void setTree(int size) {
		while (size != 1) {
			if (tree[size / 2] > tree[size]) {
				tree[size / 2] = tree[size];
			}
			size--;
		}
	}

	static long getMin(int s, int e) {
		long min = Long.MAX_VALUE;
		while (s <= e) {
			if (s % 2 == 1) {
				min = Math.min(min, tree[s]);
				s++;
			}
			s = s / 2;

			if (e % 2 == 0) {
				min = Math.min(min, tree[e]);
				e--;
			}
			e = e / 2;
		}
		
		return min;
	}
}
