import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bluRay = new int[N];

        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bluRay[i] = Integer.parseInt(st.nextToken());
            if (start < bluRay[i]) {
                start = bluRay[i]; // 블루레이 크기 중 가장 큰 값을 start에 저장
            }
            end += bluRay[i]; // 모든 블루레이 크기의 합을 end에 저장
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + bluRay[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += bluRay[i];
            }

            if (sum != 0) {
                count++;
            }

            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
