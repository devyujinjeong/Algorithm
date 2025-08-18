import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] tsp;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int N;
    static final int START = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tsp = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                tsp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[START] = true;

        calculateMoney(0,1,START); // 시작점은 고정해도 상관 없음

        System.out.println(min);
    }

    static void calculateMoney(int cur, int depth, int idx) {
        if(depth == N) {
            int last = tsp[idx][START];
            if((last != 0)) {
                int temp = cur + last;
                if(min > temp) {
                    min = temp;
                }
            }
            return;
        }

        for(int i=1; i<N; i++) {
            if(visited[i]) continue;
            if(tsp[idx][i] == 0) continue;;

            int nextCost = cur + tsp[idx][i];
            if(nextCost > min) continue; // 검사할 필요가 없음

            visited[i] = true;
            calculateMoney(nextCost, depth+1, i);
            visited[i] = false;
        }
    }
}