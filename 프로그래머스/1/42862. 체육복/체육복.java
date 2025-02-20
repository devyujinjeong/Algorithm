import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {        
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    answer++; 
                    reserve[i] = 0; 
                    lost[j] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < reserve.length; i++) {
            if (reserve[i] == 0) continue; 
            for (int j = 0; j < lost.length; j++) {
                if (lost[j] == 0) continue; 
                if (reserve[i] == lost[j] - 1 || reserve[i] == lost[j] + 1) {
                    answer++;
                    lost[j] = 0; 
                    break;
                }
            }
        }

        return answer;
    }
}
