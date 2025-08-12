import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            long sum = 0;
            int[] num = new int[a];

            for(int j=0; j<a; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            for(int k=0; k<a; k++) {
                for(int l = k+1; l<a; l++) {
                    sum += getGcd(num[k], num[l]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static int getGcd(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int mod = max % min;

        while(mod>0) {
            max = min;
            min = mod;
            mod = max % min;
        }

        return min;
    }
}
