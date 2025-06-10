import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[][] players;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        players = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);
        System.out.println(min);
    }

    static void backtracking(int start, int depth) {
        if(depth == N / 2) {
            diff();
            return;
        }

        for(int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    start += players[i][j] + players[j][i];
                } else if(!visited[i] && !visited[j]) {
                    link += players[i][j] + players[j][i];
                }
            }
        }

        int val = Math.abs(start - link);
        min = Math.min(min, val);
    }
}
