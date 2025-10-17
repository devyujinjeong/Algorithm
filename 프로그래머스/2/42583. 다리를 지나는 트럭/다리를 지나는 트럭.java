import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        int currentWeight = 0;
        
        for(int i=0; i<truck_weights.length; i++) {
            while(true) {
                int tempTruck = truck_weights[i];
                if(q.isEmpty()) {
                    q.add(tempTruck);
                    currentWeight += tempTruck;
                    answer++;
                    break;
                } else if(q.size() == bridge_length) { // 처음 들어온 차 빼기
                    int out = q.poll();
                    currentWeight -= out;
                } else {
                    if (currentWeight + tempTruck <= weight) {
                        q.add(tempTruck);
                        currentWeight += tempTruck;
                        answer++;
                        break;
                    } else {
                        // 못 올라가면 0을 넣어서 시간만 흐르게 (한 칸 전진)
                        q.add(0);
                        answer++;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}