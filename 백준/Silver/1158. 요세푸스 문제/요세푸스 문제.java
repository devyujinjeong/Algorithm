import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dq.addLast(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while (!dq.isEmpty()) {
            // K-1번 앞에서 꺼내서 뒤로 보내 회전
            for (int i = 0; i < K - 1; i++) {
                dq.addLast(dq.pollFirst());
            }
            // K번째 요소 제거 & 출력에 추가
            sb.append(dq.pollFirst());
            if (!dq.isEmpty()) sb.append(", "); // 공백 포함!
        }

        sb.append('>');
        System.out.println(sb.toString());
    }
}