import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int min = Math.min(x, y);
        int max = Math.max(x, y);

        long cost1 = (long) (x + y) * s;
        long cost2 = (long) min * w + (long) (max - min) * s;
        long cost3 = (long) max * w;
        
        if ((x + y) % 2 != 0) {
            cost3 = (long) (max - 1) * w + s;
        }

        long result = Math.min(cost1, Math.min(cost2, cost3));

        System.out.println(result);
    }
}
