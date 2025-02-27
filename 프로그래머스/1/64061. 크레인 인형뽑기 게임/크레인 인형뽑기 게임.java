import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;

        Stack<Integer> st = new Stack<>();
        int[] index = new int[len];
        
        // 가장 처음으로 0이 아닌 위치 구하기
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(board[j][i]!=0){
                    index[i]=j;
                    break;
                }
            }
        }
        
        for(int i : moves){
            if(index[i-1]<len){
                int j = index[i-1];
                int temp = board[j][i-1];
            
                if(!st.isEmpty()&&st.peek()==temp){
                    st.pop();
                    answer +=2;
                }else{
                    st.add(temp);
                }            
                index[i-1]++;  
            }
        } 

        return answer;
    }
}