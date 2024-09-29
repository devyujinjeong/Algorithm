import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[] stones = new int[n];
        int totalStones = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
            totalStones+=stones[i];
        }
        
        int m = Integer.parseInt(br.readLine());
        
        double sameColorProbability = 0.0;
        
        for (int stone : stones) {
            if (stone >= m) {
                double probability = 1.0;
                for (int i = 0; i < m; i++) {
                    probability *= (double)(stone - i) / (totalStones - i);
                }
                sameColorProbability += probability;
            }
        }
        
        System.out.printf("%.9f%n", sameColorProbability);
    }
}