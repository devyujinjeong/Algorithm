import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] depth;
	static int[] parent;
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	
	static void DFS(int v) { // DFS 사용해 깊이 구하기
		if(visited[v]) {return;}
		
		visited[v] = true;
		for(int i:tree[v]) {
			if(!visited[i]) {
				depth[i] = depth[v]+1; // 부모 노드의 depth에 1 더하기
				parent[i] = v;
				DFS(i);
			}
		}
	}
	
	static int LCA(int a, int b) {
		if(depth[a]<depth[b]) { 
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(depth[a]!=depth[b]) {
			a = parent[a];
		}
		
		while(a!=b) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		depth = new int[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		tree = new ArrayList[N+1];
		
		depth[1] = 1;
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			tree[a].add(b);
			tree[b].add(a);
		}
		
		DFS(1);
	
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken()); 
			int num2 = Integer.parseInt(st.nextToken()); 
			
			sb.append(LCA(num1, num2)+"\n");
		}
		System.out.println(sb);
	}
}
