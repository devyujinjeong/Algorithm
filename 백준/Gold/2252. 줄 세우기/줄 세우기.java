import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] D = new int[N + 1];
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer>[] H = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			H[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			H[A].add(B);
			D[B]++;
		}


		for (int i = 1; i <= N; i++) {
		    if (D[i] == 0) {
		        q.offer(i);
		    }
		}

		while (!q.isEmpty()) {
		    int node = q.poll();
		    result.add(node);
		    
		    for (int i : H[node]) {
		        D[i]--;
		        if (D[i] == 0) {
		            q.offer(i);
		        }
		    }
		}

		for (int i : result) {
		    System.out.print(i + " ");
		}
	}
}