import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] maze; // 미로
	static boolean[][] visited; // 방문 정보
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String num = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = num.charAt(j)-48;
			}
		}
		
		BFS(0,0);
		System.out.println(maze[N-1][M-1]);

	}

	static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int now[] = q.poll();
			for (int k = 0; k < 4; k++) {
				int i = now[0] + dx[k];
				int j = now[1] + dy[k];

				if (i >= 0 && j >= 0 && i < N && j < M) {
					if(maze[i][j] !=0 && !visited[i][j]) {
						visited[i][j] = true;
						maze[i][j] = maze[now[0]][now[1]]+1;
						q.add(new int[] {i,j});
					}
				}
			}
		}
	}
}