import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        
        String[] strNums = new String[n];
        
        for(int i=0; i<n; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }
    
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // 가장 큰 수가 0이면 다 0인 경우 이므로 0 리턴
        if (strNums[0].equals("0")) return "0";

        return String.join("", strNums);
    }
}
