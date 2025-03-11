class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")){
            answer[1]+= s.length();
            s = s.replace("0","");
            answer[1]-= s.length();
            s = getBinaryNum(s.length());
            answer[0]++;
        }
 
        return answer;
    }
    
    String getBinaryNum(int x) {
        StringBuilder sb = new StringBuilder();
        
        while (x > 0) {
            sb.append(x % 2);
            x /= 2;
        }
        
        return sb.reverse().toString();
    }
}