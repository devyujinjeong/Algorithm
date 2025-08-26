import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int M, N, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> result = new ArrayList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x = M-y2; x<=M-y1-1; x++) {
                for(int y = x1; y<=x2-1; y++) {
                    if(visited[x][y]) continue;

                    visited[x][y] = true;
                }
            }
        }

        int count = 0;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    count++;
                    sum = 0;
                    dfs(i,j);
                    result.add(sum);
                }
            }
        }

        Collections.sort(result);

        for(int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(count);
        System.out.print(sb);

    }

    static void dfs(int x, int y) {
        sum++;
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if(tempX<0 || tempX>=M || tempY<0 || tempY>=N) continue;

            if(visited[tempX][tempY]) continue;

            dfs(tempX, tempY);
        }
    }
}