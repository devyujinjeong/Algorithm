import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        
        // 아스키 코드를 이용해 값을 비교하고 정렬하기
        char[] word = s.toCharArray();
        int[] asc = new int[len];
        
        for(int i=0; i<len; i++){
            asc[i] = word[i];
        }
        Arrays.sort(asc);

        
        for(int i=0; i<len; i++){
            word[i] = (char)asc[len-i-1];
            answer+=word[i];
        }
    
        return answer;
    }
}