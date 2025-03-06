import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Balloon {
        int order;
        int noteValue;

        Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 풍선 개수
        Deque<Balloon> balloons = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int note = Integer.parseInt(st.nextToken());
            balloons.add(new Balloon(i + 1, note));
        }

        StringBuilder answer = new StringBuilder();
        Balloon current = balloons.pollFirst();
        answer.append(current.order);

        while (!balloons.isEmpty()) {
            int move = current.noteValue;

            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    balloons.addLast(balloons.pollFirst());
                }
                current = balloons.pollFirst();
            } else {
                for (int i = 1; i < -move; i++) {
                    balloons.addFirst(balloons.pollLast());
                }
                current = balloons.pollLast();
            }

            answer.append(" ").append(current.order);
        }

        System.out.println(answer);
        br.close();
    }
}