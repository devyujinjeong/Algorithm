import java.util.*;

class Solution {
    static ArrayList<Node>[] tree;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 트리 초기화 하기
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int city1 = r[0];
            int city2 = r[1];
            int time = r[2];
            
            // 양방향 도로 추가
            tree[city1].add(new Node(city2, time));
            tree[city2].add(new Node(city1, time));
        }

        // 최단 거리를 저장하기 위한 배열
        int[] distances = new int[N + 1];
        // 최댓값으로 채우기
        Arrays.fill(distances, Integer.MAX_VALUE);
        // 시작하는 위치 (1번 마을)
        distances[1] = 0;
        
        // 시간을 우선순위로 결정
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            int tempC = temp.city;
            int tempT = temp.time;
            
            // 만약 현재 저장된 거리보다 tempT가 더 크면 무시
            if(tempT > distances[tempC]) continue;
            
            
            for (Node neighbor : tree[tempC]) {
                int nextCity = neighbor.city;
                int nextTime = tempT + neighbor.time;
                
                if (nextTime < distances[nextCity]) {
                   distances[nextCity] = nextTime;
                   pq.offer(new Node(nextCity, nextTime));
                }
            }
        }
            
        for(int i=1; i<=N; i++){
            if(distances[i] <= K) {
                answer++;
            }    
        }
        
        return answer;
    }
}

class Node implements Comparable<Node> {
    int city;
    int time;
    
    public Node(int city, int time) {
        this.city = city;
        this.time = time;
    }
    
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.time, other.time);
    }
}