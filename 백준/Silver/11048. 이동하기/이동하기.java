import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<M; i++) {
			maze[0][i] +=maze[0][i-1]; 
		}
		
		for(int i=1; i<N; i++) {
			maze[i][0] +=maze[i-1][0]; 
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				int max = Math.max(maze[i-1][j-1], Math.max(maze[i][j-1], maze[i-1][j]));
				maze[i][j] += max; 
			}
		}
		
		System.out.println(maze[N-1][M-1]);
	}
}