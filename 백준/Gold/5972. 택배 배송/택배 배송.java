import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 헛간의 개수
        int M = Integer.parseInt(st.nextToken());

        int[] answer = new int[N+1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        ArrayList<ArrayList<Node>> map = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            map.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(a).add(new Node(b,c));
            map.get(b).add(new Node(a,c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        answer[1] = 0;

        while(!pq.isEmpty()){
            Node temp = pq.poll();
            int now = temp.store;
            int nowCost = temp.cost;

            if(answer[now] < nowCost) continue;

            for(Node node : map.get(now)){
                if(answer[node.store] > nowCost + node.cost){
                    answer[node.store] = nowCost + node.cost;
                    pq.offer(new Node(node.store,nowCost + node.cost));
                }
            }
        }

        System.out.println(answer[N]);

    }
}

class Node implements Comparable<Node>{
    int store;
    int cost;

    public Node(int store, int cost){
        this.store = store;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}