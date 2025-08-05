import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int a = Integer.parseInt(br.readLine());

            int[][] dp = new int[2][a+1];

            for(int j=0; j<2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<a; k++){
                    dp[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];

            for(int k=2; k<a; k++) {
                dp[0][k] += Math.max(dp[1][k-1], dp[1][k-2]);
                dp[1][k] += Math.max(dp[0][k-1], dp[0][k-2]);
            }

            sb.append(Math.max(dp[0][a-1], dp[1][a-1]));

            if(i!=N-1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}