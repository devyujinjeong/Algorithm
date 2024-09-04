import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int answer = 0;
	static int del = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N];
		visited = new boolean[N];
		
		int root = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a != -1) {
				tree[i].add(a);
				tree[a].add(i);
			}else {
				root = i;
			}
		}

		del = Integer.parseInt(br.readLine());
		if(del == root) {
			System.out.println(0);
		}else {
			DFS(root);
			System.out.println(answer);
		}
		
	}
	
	static void DFS(int n) {
		visited[n] = true;
		int c = 0;
		for(int i: tree[n]) {
			if(!visited[i]&& i!=del) {
				c++;
				DFS(i);
			}
		}
		
		if(c == 0) {
			answer++;
		}
	}
}