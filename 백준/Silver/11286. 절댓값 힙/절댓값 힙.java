import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
        // 우선순위 큐를 사용하여 기준대로 정렬하기
		PriorityQueue<Integer> absQ = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);

			if (abs1 == abs2) {
				return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수 우선 정렬하기(가장 작은 수)
			} else {
				return abs1 - abs2; // 절댓값을 기준으로 정렬하기
			}
		});

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x != 0) {
				absQ.add(x); // 0이 아닌 경우 값을 넣기
			} else {
				if (absQ.isEmpty()) { // 큐가 비어있는 경우
					System.out.println(0);
				} else { // 큐에 값이 있는 경우 절댓값이 가장 작은 값을 뽑기
					System.out.println(absQ.poll());
				}
			}
		}
	}
}