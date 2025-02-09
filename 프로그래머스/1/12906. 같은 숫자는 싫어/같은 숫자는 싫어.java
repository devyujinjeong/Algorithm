import java.util.*;

public class Solution {
    public Stack<Integer> solution(int[] arr) {
        
        // 1. 스택에 모든 값을 넣기
        // 2. 스택에서 값을 빼서 배열에 넣기
        // 3. 스택에서 값을 뺄 때마다 연속되는 값인지 검사하기
        Stack<Integer> answer = new Stack<Integer>();
        
        int len = arr.length;
        
        answer.push(arr[0]);
        for(int i=1; i<len; i++){
            if(answer.peek()!=arr[i]){
                answer.push(arr[i]);
            }
        }
        
        return answer;
    }
}