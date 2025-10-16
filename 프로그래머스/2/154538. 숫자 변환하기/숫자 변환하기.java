import java.util.*;

class Solution {
    
    static int[] dist;
    
    public int solution(int x, int y, int n) {
        if(x==y) return 0; // 숫자가 같은 경우에는 0을 return 
    
        dist = new int[y+1];
        Arrays.fill(dist, -1);
                        
        return countMin(n, x, y);
    }
    
    static int countMin(int n, int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            int nextDist = dist[cur] + 1; // 다음 거리
            
            int[] nexts = {cur + n, cur * 2, cur * 3};
            for(int nx : nexts) {
                if(nx > y) continue; // y를 초과하는 경우에는 확인할 필요 없음 
                if(dist[nx] != -1) continue; // -1이 아니면 방문 했으므로 건너뛰기
                dist[nx] = nextDist; // nextDist 저장하기
                if(nx == y) return nextDist;
                q.add(nx);
            }
        }
        
        return -1;
    }
}