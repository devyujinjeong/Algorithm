import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String num = Long.toString(n);
        char[] d = num.toCharArray();
        
        Arrays.sort(d);
        String e = "";
        for(int i=num.length()-1; i>=0; i--){
            e += Integer.toString((int)d[i]-48);
        }
        
        answer = Long.parseLong(e);        
        
        return answer;
    }
}