import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
	int num;
	int time;

	public Info(int num, int time) {
		this.num = num;
		this.time = time;
	}

	public int compareTo(Info n) {
		return Integer.compare(this.time, n.time);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 도시의 개수
		int m = Integer.parseInt(st.nextToken()); // 도로의 개수
		int k = Integer.parseInt(st.nextToken()); // 원하는 최단경로 경우
		int[][] W = new int[1001][1001];

		PriorityQueue<Integer>[] dq = new PriorityQueue[n + 1];
		PriorityQueue<Info> pq = new PriorityQueue<>();

		Comparator<Integer> cp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1;
			}

		};

		for (int i = 0; i <= n; i++) {
			dq[i] = new PriorityQueue<Integer>(k, cp);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			W[a][b] = c;
		}

		pq.add(new Info(1, 0));
		dq[1].add(0);

		while (!pq.isEmpty()) {
			Info now = pq.poll();
			for (int i = 1; i <= n; i++) {
				if (W[now.num][i] != 0) {
					int t = now.time + W[now.num][i];
					if (dq[i].size() < k) {
						dq[i].add(t);
						pq.add(new Info(i, t));
					} else if (dq[i].peek() > t) {
						dq[i].poll();
						dq[i].add(t);
						pq.add(new Info(i, t));
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (dq[i].size() == k) {
				bw.write(dq[i].peek() + "\n");
			} else {
				bw.write(-1 + "\n");
			}
		}
		
		bw.flush();
		bw.close();

	}
}