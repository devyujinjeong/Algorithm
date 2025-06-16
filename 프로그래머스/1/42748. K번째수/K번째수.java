import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int s = commands[i][0]; // 시작
            int e = commands[i][1]; // 끝
            int t = commands[i][2]; // 타겟
            
            int[] arr2 = Arrays.copyOfRange(array, s-1, e);
            Arrays.sort(arr2);
            answer[i] = arr2[t-1];
        }
        
        
        return answer;
    }
}