import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(a*b/getGcd(a,b)).append("\n");
        }

        System.out.println(sb);

    }

    static int getGcd(int a, int b) {
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        int mod = max % min;

        while(mod>0) {
            max = min;
            min = mod;
            mod = max % mod;
        }

        return min;
    }

}