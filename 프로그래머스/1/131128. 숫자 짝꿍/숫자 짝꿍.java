import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        
        for (char c : X.toCharArray()) { xCount[c - '0']++; }
        for (char c : Y.toCharArray()) { yCount[c - '0']++; }

        for (int i = 9; i >= 0; i--) {
            int min = Math.min(xCount[i], yCount[i]);
            answer.append(String.valueOf(i).repeat(min));
        }

        if (answer.length() == 0) {
            return "-1";
        }
        
        if (answer.toString().matches("^0+$")) {
            return "0";
        }
        
        return answer.toString();
    }
}
