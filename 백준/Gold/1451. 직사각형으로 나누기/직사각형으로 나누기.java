import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] rectangle;
    static long[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        rectangle = new int[N + 1][M + 1];
        sum = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine().trim();
            for (int j = 1; j <= M; j++) {
                rectangle[i][j] = line.charAt(j - 1) - '0';
            }
        }

        // 누적합 구하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + rectangle[i][j];
            }
        }

        long ans = 0;

        // 1) 세로 3등분
        for (int c1 = 1; c1 <= M - 2; c1++) {
            for (int c2 = c1 + 1; c2 <= M - 1; c2++) {
                long s1 = getSum(1, 1, N, c1);
                long s2 = getSum(1, c1 + 1, N, c2);
                long s3 = getSum(1, c2 + 1, N, M);
                ans = Math.max(ans, s1 * s2 * s3);
            }
        }

        // 2) 가로 3등분
        for (int r1 = 1; r1 <= N - 2; r1++) {
            for (int r2 = r1 + 1; r2 <= N - 1; r2++) {
                long s1 = getSum(1, 1, r1, M);
                long s2 = getSum(r1 + 1, 1, r2, M);
                long s3 = getSum(r2 + 1, 1, N, M);
                ans = Math.max(ans, s1 * s2 * s3);
            }
        }

        // 3) 왼쪽 세로 + 오른쪽 가로 2개
        for (int c = 1; c <= M - 1; c++) {
            for (int r = 1; r <= N - 1; r++) {
                long s1 = getSum(1, 1, N, c);
                long s2 = getSum(1, c + 1, r, M);
                long s3 = getSum(r + 1, c + 1, N, M);
                ans = Math.max(ans, s1 * s2 * s3);
            }
        }

        // 4) 오른쪽 세로 + 왼쪽 가로 2개
        for (int c = 1; c <= M - 1; c++) {
            for (int r = 1; r <= N - 1; r++) {
                long s1 = getSum(1, c + 1, N, M);
                long s2 = getSum(1, 1, r, c);
                long s3 = getSum(r + 1, 1, N, c);
                ans = Math.max(ans, s1 * s2 * s3);
            }
        }

        // 5) 위쪽 가로 + 아래쪽 세로 2개
        for (int r = 1; r <= N - 1; r++) {
            for (int c = 1; c <= M - 1; c++) {
                long s1 = getSum(1, 1, r, M);
                long s2 = getSum(r + 1, 1, N, c);
                long s3 = getSum(r + 1, c + 1, N, M);
                ans = Math.max(ans, s1 * s2 * s3);
            }
        }

        // 6) 아래쪽 가로 + 위쪽 세로 2개
        for (int r = 1; r <= N - 1; r++) {
            for (int c = 1; c <= M - 1; c++) {
                long s1 = getSum(r + 1, 1, N, M);
                long s2 = getSum(1, 1, r, c);
                long s3 = getSum(1, c + 1, r, M);
                ans = Math.max(ans, s1 * s2 * s3);
            }
        }

        System.out.println(ans);
    }

    static long getSum(int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
    }
}