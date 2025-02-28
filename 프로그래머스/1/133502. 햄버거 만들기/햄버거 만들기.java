import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int[] pattern = {1, 2, 3, 1};

        for (int data : ingredient) {
            stack.push(data);
            
            // 스택의 크기가 4이상인 경우에 조사하기
            if(stack.size()>=4){
                boolean match = true;
                for(int i=0; i<4; i++){
                    if (stack.get(stack.size() - 4 + i) != pattern[i]) {
                        match = false;
                        break;
                    }
                }
                
                if (match) {
                for (int i = 0; i < 4; i++) {
                    stack.pop();
                }
                answer++;
                }
            }

        }
        return answer;
    }
}
