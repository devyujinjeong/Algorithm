import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] land;
    static boolean[][] visited;
    static int N, height, answer;

    public int solution(int[][] land, int height) {
        answer = 0;
        
        this.land = land;
        this.height = height;
        N = land.length;
        visited = new boolean[N][N];
        
        bfs(new Node(0,0,0));
        
        return answer;
        
    }
    
    private void bfs(Node start) {
        // 비용을 기준으로 우선순위 설정
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(start);
        
        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            
            int tempX = temp.x;
            int tempY = temp.y;
            int tempC = temp.cost;
            
            // 이미 방문한 경우
            if(visited[tempX][tempY]) continue;
             
            visited[tempX][tempY] = true;
            
            answer += tempC;
            
            // 4개의 방향으로 확인하기
            for(int i=0; i<4; i++) {
                int nowX = tempX + dx[i];
                int nowY = tempY + dy[i];
                    
                // 만약 위치에서 벗어하는 경우에는 확인하지 않음
                if(nowX < 0 || nowX >= N || nowY < 0 || nowY >= N) continue;

                // 이전 위치와 현재 위치의 비용 차이
                int diff = Math.abs(land[tempX][tempY] - land[nowX][nowY]);

                // 범위 내의 높이 차인 경우
                if (diff <= height) {
                    pq.offer(new Node(nowX, nowY, 0));
                } else { // 범위를 벗어나는 경우
                    pq.offer(new Node(nowX, nowY, diff)); 
                }
            }
        }
    }
}

// 위치와 높이차를 저장하는 클래스
class Node{
    int x;
    int y;
    int cost; 
    
    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}