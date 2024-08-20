import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static int[] check;
	static boolean[] visited;
	static boolean even;

	static void DFS(int node) {
		if (visited[node]) {
			return;
		}

		visited[node] = true;

		for (int i : A[node]) {
			if (!visited[i]) {
				check[i] = (check[node] + 1) % 2;
				DFS(i);
			} else if (check[node] == check[i]) {
				even = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			check = new int[N + 1];
			A = new ArrayList[N + 1];
			visited = new boolean[N + 1];
			even = true;

			for (int j = 1; j <= N; j++) {
				A[j] = new ArrayList<Integer>();
			}

			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				A[u].add(v);
				A[v].add(u);
			}

			for (int j = 1; j <= N; j++)
				if (even) {
					DFS(j);
				}else {
					break;
				}
			
			if(even) {
				bw.write("YES"+"\n");
			}else {
				bw.write("NO"+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
