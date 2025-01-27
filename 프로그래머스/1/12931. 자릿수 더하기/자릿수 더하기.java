import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        // 1. n을 string으로 바꾸기
        String num = Integer.toString(n);
        
        // 2. split을 이용해 각각의 값을 배열에 저장하기
        String[] a = num.split("");
        
        // 3. 값을 더해주기
        for(int i=0; i<a.length; i++){
            answer+=Integer.parseInt(a[i]);
        }

        return answer;
    }
}