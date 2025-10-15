import java.util.*;

class Solution {
    public int solution(int[] order) {
        int count = 0;
        int n = order.length;
        
        Stack<Integer> c1 = new Stack<>(); // 기존의 컨테이너 벨트 
        Stack<Integer> c2 = new Stack<>(); // 보조 컨테이너 벨트
        
        // 기존의 컨테이너에 상자를 순서대로 넣기
        for(int i=n; i>=1; i--) {
            c1.push(i);
        }
        
        int i = 0;
        while(i<n) {
            if(!c1.isEmpty() && c1.peek() == order[i]) {
                count++;
                c1.pop();
                i++;
            } else if (!c2.isEmpty() && c2.peek() == order[i]){
                count++;
                c2.pop();
                i++;
            } else if (!c1.isEmpty()){
                c2.push(c1.pop());
            } else {
                break;
            }
        }
        
        return count;
    }
}