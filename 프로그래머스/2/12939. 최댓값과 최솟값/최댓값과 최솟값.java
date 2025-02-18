import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sNum = s.split(" ");
        int len = sNum.length;
        int[] num = new int[sNum.length];
        
        for(int i=0; i<len; i++){
            num[i] = Integer.parseInt(sNum[i]);
        }
        
        Arrays.sort(num);
        
        answer += Integer.toString(num[0])+" ";
        answer += Integer.toString(num[len-1]);
        
        
        
        return answer;
    }
}