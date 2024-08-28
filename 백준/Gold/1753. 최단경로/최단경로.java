import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int index;
	int value;

	public Node(int index, int value) {
		this.index = index;
		this.value = value;
	}

	public int compareTo(Node n) {
		return Integer.compare(this.value, n.value);
	}
}

public class Main {
	static ArrayList<Node>[] A;
	static int[] D;
	static boolean[] visited;
	static int V;
	static PriorityQueue<Node> q = new PriorityQueue<>();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 노드의 개수
		int E = Integer.parseInt(st.nextToken()); // 에지의 개수
		int start = Integer.parseInt(br.readLine()); // 시작점
		D = new int[V + 1]; // 최단 거리 배열
		visited = new boolean[V + 1]; // 방문 배열
		A = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			A[i] = new ArrayList<Node>();
		}

		for (int i = 0; i <= V; i++) {
			D[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			A[u].add(new Node(v, w));
		}

		q.add(new Node(start, 0));
		D[start] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();
			int ni = now.index;
			if (visited[ni]) {continue;} 
			visited[ni] = true;
			for (int j = 0; j < A[ni].size(); j++) {
				Node next = A[ni].get(j);
				int i = next.index;
				int v = next.value;

				int distance = D[ni] + v;
				if (distance < D[i]) {
					D[i] = distance;
					q.add(new Node(i, D[i]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (visited[i]) {
				bw.write(D[i] + "\n");
			} else {
				bw.write("INF" + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}