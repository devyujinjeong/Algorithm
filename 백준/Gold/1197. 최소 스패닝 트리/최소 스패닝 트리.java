import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int node1;
	int node2;
	int v;

	public Edge(int node1, int node2, int v) {
		this.node1 = node1;
		this.node2 = node2;
		this.v = v;
	}

	@Override
	public int compareTo(Edge e) {
		return this.v - e.v;
	}
}

public class Main {
	static PriorityQueue<Edge> pq;
	static int[] uf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();
		uf = new int[V+1];

		for (int i = 0; i < V; i++) {
			uf[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			pq.add(new Edge(s, e, v));
		}

		int result = 0;
		int useEdge = 0;

		while (useEdge < V - 1) {
			Edge now = pq.poll();
			int s = now.node1;
			int e = now.node2;

			if (find(s) != find(e)) {
				union(s,e);
				result += now.v;
				useEdge++;
			}
		}

		System.out.println(result);

	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			uf[b] = a;
		}
	}

	static int find(int c) {
		if (c == uf[c]) {
			return c;
		} else {
			return uf[c] = find(uf[c]);
		}
	}
}
