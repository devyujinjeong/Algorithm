import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1;

        int[][] classroom = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            classroom[i][0] = Integer.parseInt(st.nextToken());
            classroom[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(classroom, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 끝나는 시각 min-heap
        pq.add(classroom[0][1]);

        for(int i=1; i<N; i++) {
            if(classroom[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(classroom[i][1]);

        }

        System.out.println(pq.size());
    }
}