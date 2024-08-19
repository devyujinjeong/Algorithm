import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<cNode>[] A;
	static long[] result;
	static boolean[] visited;
	static long lcm;

	static long findGcd(long p, long q) { // 최대공약수를 찾는 메서드
		long a = Math.max(p, q);
		long b = Math.min(p, q);
		long mod = a % b;

		while (mod != 0) {
			a = b;
			b = mod;
			mod = a % b;
		}
		return b;
	}

	static void DFS(int node) { // DFS 작성
		if (visited[node]) {
			return;
		}

		visited[node] = true;
		for (cNode i : A[node]) { 
			int next = i.getB();
			if (!visited[next]) {
				result[next] = result[node]/i.getP()*i.getQ();
				DFS(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		A = new ArrayList[N];
		visited = new boolean[N];
		result = new long[N];
		lcm = 1;

		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<cNode>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			A[a].add(new cNode(b,p,q));
			A[b].add(new cNode(a,q,p));
			
			lcm *= p*q/findGcd(p,q);
		}

		result[0] = lcm;
		DFS(0);
		
		long mgcd = result[0];
		for(int i=1; i<N; i++) {
			mgcd = findGcd(mgcd,result[i]);
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(result[i]/mgcd+" ");
		}
	}
}

class cNode {
	int b, p, q;

	public cNode(int b, int p, int q) {
		super();
		this.b = b;
		this.p = p;
		this.q = q;
	}
	
	public int getB() {
		return b;
	}
	
	public int getP() {
		return p;
	}
	
	public int getQ() {
		return q;
	}
}