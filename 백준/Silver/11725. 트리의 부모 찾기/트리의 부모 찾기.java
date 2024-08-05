import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A; // 인접 배열을 저장할 리스트
	static int[] result; // 각각의 부모들을 저장할 리스트
	static boolean[] visited; // 방문 여부
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
				
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		DFS(1);
		
		for(int i=2; i<N+1; i++) {
			bw.write(result[i]+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void DFS(int v) {
		if(visited[v]) {return;}
		
		visited[v] = true;
		for(int i : A[v]) {
			if(!visited[i]) {
				result[i] = v; // i의 부모는 v이니깐!
				DFS(i);
			}
		}
	}
}
