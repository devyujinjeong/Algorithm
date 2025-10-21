import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 마을의 개수

        int[][] houses = new int[N][2];
        int answer = 0;
        long total = 0L; // 총 인원 수

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            houses[i][0] = Integer.parseInt(st.nextToken());
            houses[i][1] = Integer.parseInt(st.nextToken());

            total += houses[i][1];
        }

        Arrays.sort(houses, (o1, o2) -> o1[0] - o2[0]);

        long sum = 0L;
        for(int i=0; i<N; i++) {
            sum += houses[i][1];
            if((total+1)/2 <= sum) {
                answer = houses[i][0];
                break;
            }
        }

        System.out.println(answer);

    }

}