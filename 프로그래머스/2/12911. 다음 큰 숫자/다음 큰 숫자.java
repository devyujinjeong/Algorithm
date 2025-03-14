class Solution {
    public int solution(int n) {
        int answer = 0;
                
        String binary = Integer.toBinaryString(n);
        String oneNum = binary.replace("0","");
        int len = oneNum.length();
        
        while (true) {
            n++; 
            binary = Integer.toBinaryString(n);
            oneNum = binary.replace("0","");
            
            if (len == oneNum.length()) {
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}
