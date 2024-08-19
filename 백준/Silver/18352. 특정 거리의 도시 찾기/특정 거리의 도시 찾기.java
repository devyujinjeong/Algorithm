import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] a;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[N+1];
		result = new int[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			a[r1].add(r2);	
		}
		
		BFS(X);
		
		int count = 0;
		for(int i=0; i<N+1; i++) {
			if(result[i]==K) {
				System.out.println(i);
				count++;
			}
		}
		
		if(count==0) {
			System.out.println(-1);
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			for(int i: a[n]) {
				if(!visited[i]) {
					result[i] = result[n]+1;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
	
	
}
