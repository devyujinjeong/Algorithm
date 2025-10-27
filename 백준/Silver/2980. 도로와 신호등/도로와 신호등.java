import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 신호등 개수
        int L = Integer.parseInt(st.nextToken()); // 도로 길이

        int time = 0;   // 현재까지 경과 시간
        int prev = 0;   // 직전 신호등 위치

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken()); // 신호등 위치
            int R = Integer.parseInt(st.nextToken()); // 빨간불 시간
            int G = Integer.parseInt(st.nextToken()); // 초록불 시간

            // 이전 지점 -> 이번 신호등까지 이동
            time += (D - prev);

            // 신호 대기 계산
            int cycle = R + G;
            int phase = time % cycle;
            if (phase < R) {              // 아직 빨간불이면
                time += (R - phase);      // 빨간불 남은 시간만큼 대기
            }

            prev = D; // 현재 신호등을 직전 지점으로 갱신
        }

        // 마지막 신호등 -> 도로 끝 L까지 이동
        time += (L - prev);

        System.out.println(time);
    }
}