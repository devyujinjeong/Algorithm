import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Edge {
	int start;
	int end;
	int time;

	public Edge(int start, int end, int time) {
		this.start = start;
		this.end = end;
		this.time = time;
	}
}

public class Main {
	static int inf = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 도시의 수
		int M = Integer.parseInt(st.nextToken()); // 버스의 수
		boolean check = true;

		Edge[] edges = new Edge[M + 1];
		long[] D = new long[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(A, B, C);
		}

		D[1] = 0;
		for (int i = 2; i <= N; i++) {
			D[i] = inf;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Edge edge = edges[j];
				int s = edge.start;
				int e = edge.end;
				int t = edge.time;

				if (D[s] != inf && D[e] > D[s] + t) {
					D[e] = D[s] + t;
				}
			}
		}

		// 음의 사이클 확인하기
		for (int i = 0; i < M; i++) {
			Edge edge = edges[i];

			int s = edge.start;
			int e = edge.end;
			int t = edge.time;

			if (D[s] != inf && D[e] > D[s] + t) {
				check = false;
				break;
			}
		}

		if (check) {
			for (int i = 2; i <= N; i++) {
				if (D[i] == inf) {
					bw.write(-1 + "\n");
				} else {
					bw.write(D[i] + "\n");
				}
			}
		} else {
			bw.write(-1 + "\n");
		}

		bw.flush();
		bw.close();
	}
}
