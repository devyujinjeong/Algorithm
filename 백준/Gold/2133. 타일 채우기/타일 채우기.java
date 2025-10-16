import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N%2==1) {
            System.out.println(0);
            return;
        }
        
        long[] dp = new long[31];
        dp[2] = 3; dp[4] = 11;
        
        for(int i=6; i<=N; i+=2){
            dp[i] = 4 * dp[i-2] - dp[i-4];
        }
         
        System.out.println(dp[N]);
    }
}