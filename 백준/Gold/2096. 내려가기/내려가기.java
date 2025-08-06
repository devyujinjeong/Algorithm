import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] maxS = new int[N][3];
        int[][] minS = new int[N][3];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                maxS[i][j] = Integer.parseInt(st.nextToken());
                minS[i][j] = maxS[i][j];
            }
        }

        for(int i=1; i<N; i++) {
            maxS[i][0] = maxS[i][0] + Math.max(maxS[i-1][0], maxS[i-1][1]);
            maxS[i][1] = maxS[i][1] + Math.max(Math.max(maxS[i-1][0], maxS[i-1][1]),maxS[i-1][2]) ;
            maxS[i][2] = maxS[i][2] + Math.max(maxS[i-1][1], maxS[i-1][2]);

            minS[i][0] = minS[i][0] + Math.min(minS[i-1][0], minS[i-1][1]);
            minS[i][1] = minS[i][1] + Math.min(Math.min(minS[i-1][0], minS[i-1][1]),minS[i-1][2]) ;
            minS[i][2] = minS[i][2] + Math.min(minS[i-1][1], minS[i-1][2]);
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            if(max<maxS[N-1][i]) {
                max = maxS[N-1][i];
            }

            if(min>minS[N-1][i]) {
                min = minS[N-1][i];
            }
        }

        System.out.println(max + " " + min);
    }
}
