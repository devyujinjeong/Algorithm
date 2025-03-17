import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int node1;
    int node2;
    int cost;

    public Node(int node1, int node2, int cost){
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node n){
        return this.cost - n.cost;
    }
}

public class Main {
    static int[] pCity;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pCity = new int[N+1];
        for(int i=1; i<=N; i++){
            pCity[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());
            pq.add(new Node(a,b,c));
        }

        int result = 0;
        int countEdge = 0;

        // 마을이 2개로 나눠지기 때문에
        while(countEdge<N-2){
            Node temp = pq.poll();
            int node1 = temp.node1;
            int node2 = temp.node2;

            // 만약 부모가 같다면 이미 연결된 것임
            if(find(node1)!=find(node2)){
                union(node1, node2);
                result+=temp.cost;
                countEdge++;
            }
        }

        System.out.println(result);

    }

    static void union(int a, int b){
        int pA = find(a);
        int pB = find(b);

        if(pA!=pB){
            pCity[pB] = pA;
        }
    }

    static int find(int n){
        if(pCity[n] != n){
            pCity[n] = find(pCity[n]);
        }

        return pCity[n];
    }
}