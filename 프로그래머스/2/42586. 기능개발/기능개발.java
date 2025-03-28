import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        int len = progresses.length;
            
        for(int i=0; i<len; i++){
            int work = 100-progresses[i];
            if(work%speeds[i] == 0){
                work/=speeds[i];
            }else{
                work/=speeds[i];
                work++;
            }
            q.add(work);
        }

        int count = 1;
        int total = 0;
        int temp = q.poll();
        while(!q.isEmpty()){
            if(q.peek()<=temp){
                count++;
                q.poll();
            }else{
                answer.add(count);
                count = 1;
                temp = q.poll();
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}