import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char num : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < num) {
                stack.pollLast();
                k--;
            }
            stack.addLast(num);
        }

        while (k-- > 0) {
            stack.pollLast();
        }

        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }
}
