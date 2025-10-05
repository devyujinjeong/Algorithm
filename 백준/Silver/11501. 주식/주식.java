import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] stock = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(findMaxRevenue(stock, N)).append("\n");
        }

        System.out.println(sb);
    }

    static long findMaxRevenue(int[] stock, int N) {
        long total = 0;
        int max = 0;

        for (int i = N-1; i >= 0; i--) {
            if(stock[i]>=max) {
                max = stock[i];
            } else {
                total += max - stock[i];
            }
        }

        return total;
    }
}