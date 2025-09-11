import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] t = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            t[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(t);

        long max = 0;
        if(N%2==1) { // 홀수인 경우
            max = t[N];

            for(int i=1; i<=N/2; i++) {
                long temp  = t[i] + t[N-i];
                max = Math.max(max, temp);
            }
        } else { // 짝수인 경우
            for(int i=1; i<=N/2; i++) {
                long temp  = t[i] + t[N-i+1];
                max = Math.max(max, temp);
            }
        }

        System.out.println(max);

    }
}