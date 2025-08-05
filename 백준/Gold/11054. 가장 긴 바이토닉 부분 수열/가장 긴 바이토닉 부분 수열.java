import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        int[] num = new int[N];
        int[][] dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());

            dp[i][0] = 1;
            dp[i][1] = 0;
        }

        // i번째 숫자를 기준으로 오름차순과 내림차순의 값 구해서 더하기
        // 1. 증가 수열
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) { // i보다 j가 더 이전 위치에 있음
                // i 기준으로 앞은 오름차순
                if(num[i] > num[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
        }

        // 2. 감소수열
        for(int i = N-1; i >= 0; i--) {
            for(int j = N-1; j > i; j--) {
                if(num[i] > num[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            int total = dp[i][0] + dp[i][1];
            if(max < total) {
                max = total;
            }
        }

        System.out.println(max);
    }
}