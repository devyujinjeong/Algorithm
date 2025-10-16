import java.util.*;

class Solution {
    
    static int[] dist;
    
    public int solution(int x, int y, int n) {
        if(x==y) return 0;
    
        dist = new int[y+1];
        Arrays.fill(dist, -1);
                        
        return countMin(n, x, y);
    }
    
    static int countMin(int n, int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dist[s] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            int nextDist = dist[cur] + 1;
            
            int[] nexts = {cur + n, cur * 2, cur * 3};
            for(int nx : nexts) {
                if(nx > e) continue;
                if(dist[nx] != -1) continue;
                dist[nx] = nextDist;
                if(nx == e) return nextDist;
                q.add(nx);
            }
        }
        
        return -1;
    }
}