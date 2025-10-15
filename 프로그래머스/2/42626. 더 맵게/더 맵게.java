import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int n = scoville.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++) {
            pq.add(scoville[i]);
        }
        
        for(int i=0; i<n-1; i++) { // 섞어도 n-1번까지만 섞을 수 있으므로
            if(pq.peek()>=K) break;
            
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;
        }
        
        return pq.peek()>=K?answer:-1;
    }
}