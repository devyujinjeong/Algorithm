import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int weight;
    int price;

    public Node(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Node o) {
        return o.price - this.price; // price 기준 내림차순 정렬
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Node> jewels = new ArrayList<>();
        ArrayList<Integer> bags = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels.add(new Node(weight, price));
        }

        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bags);
        Collections.sort(jewels, (a, b) -> a.weight - b.weight);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int jIndex = 0;
        long total = 0;

        for (int i = 0; i < K; i++) {
            int bagWeight = bags.get(i);

            // 현재 가방에 담을 수 있는 모든 보석을 pq에 추가
            while (jIndex < N && jewels.get(jIndex).weight <= bagWeight) {
                pq.add(jewels.get(jIndex));
                jIndex++;
            }

            // 가장 비싼 보석을 선택
            if (!pq.isEmpty()) {
                total += pq.poll().price;
            }
        }

        System.out.println(total);
    }
}
