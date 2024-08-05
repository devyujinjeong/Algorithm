import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean check;
	static ArrayList<Integer>[] relation;
	static boolean[] visited;

	static void DFS(int v, int d) {		
		if(d==5) {
			check = true;
			return;
		}

		visited[v] = true;

		for (int i : relation[v]) {
			if (!visited[i]) {
				DFS(i,d+1);
			}
		}
		
		visited[v] = false; 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		relation = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			relation[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			relation[a].add(b);
			relation[b].add(a);
		}
		
		for(int i=0; i<N; i++) {
			DFS(i,1);
			if(check) {
				break;
			}
		}
		
		if(check) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		

	}

}
