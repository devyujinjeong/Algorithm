import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        // 1. 스택에 모든 값을 넣기
        // 2. 스택에서 값을 빼서 배열에 넣기
        // 3. 스택에서 값을 뺄 때마다 연속되는 값인지 검사하기
        Stack<Integer> st = new Stack<Integer>();
        
        int len = arr.length;
        st.push(arr[len-1]);
        for(int i=arr.length-2; i>=0; i--){
            if(st.peek()!=arr[i]){
                st.push(arr[i]);
            }
        }
        
        int a = st.size();
        for(int i=0; i<a; i++){
            answer.add(st.pop());
        }
        
        return answer;
    }
}