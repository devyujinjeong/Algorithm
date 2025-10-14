import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length; // 배열의 길이
        int[] answer = new int[n];
        
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i=0; i<n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}