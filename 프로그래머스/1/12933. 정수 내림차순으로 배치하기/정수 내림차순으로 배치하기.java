import java.util.*;

class Solution {
    public long solution(long n) {
        // 1. 숫자를 문자열로 바꾸고
        String[] digits = String.valueOf(n).split("");

        // 2. 내림차순 정렬
        Arrays.sort(digits, Collections.reverseOrder());

        // 3. 문자열을 합치고 long으로 변환
        StringBuilder sb = new StringBuilder();
        for (String digit : digits) {
            sb.append(digit);
        }

        return Long.parseLong(sb.toString());
    }
}
