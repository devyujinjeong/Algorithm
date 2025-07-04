import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        // 1번째 집을 터는 경우
        int[] dp_first = new int[n]; 
        dp_first[0] = money[0];
        dp_first[1] = Math.max(money[0], money[1]);
        
        for(int i=2; i<n-1; i++) {
            dp_first[i] = Math.max(dp_first[i - 1], dp_first[i - 2] + money[i]);
        }
        
        // 마지막 집을 터는 경우 
        int[] dp_end = new int[n];
        dp_end[1] = money[1];
        for(int i = 2; i < n; i++) {
            dp_end[i] = Math.max(dp_end[i - 1], dp_end[i - 2] + money[i]);
        }
        
        return Math.max(dp_first[n - 2], dp_end[n - 1]);
    }
}