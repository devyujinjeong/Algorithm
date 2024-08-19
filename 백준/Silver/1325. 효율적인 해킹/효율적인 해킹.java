import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] computer;
	static boolean[] visited;

	static int DFS(int v) {
		visited[v] = true;
		int count = 1;

		for (int i : computer[v]) {
			if (!visited[i]) {
				count += DFS(i);
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		computer = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		int[] result = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			computer[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			computer[B].add(A);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			result[i] = DFS(i);
		}

		int max = result[1];
		for (int i = 2; i <= N; i++) {
			if (max < result[i]) {
				max = result[i];
			}
		}

		for (int i = 1; i <= N; i++) {
			if (max == result[i]) {
				System.out.print(i+" ");
			}
		}
	}
}
