import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 입력 N값
        long[] result = new long[1000001];
        long MOD = 1000000000;

        result[1] = 0; 
        if (N > 1) {
            result[2] = 1;
        }

        for (int i = 3; i <= N; i++) {
            result[i] = (i - 1) * (result[i - 1] + result[i - 2]) % MOD;
        }

        System.out.println(result[N]);
    }
}
