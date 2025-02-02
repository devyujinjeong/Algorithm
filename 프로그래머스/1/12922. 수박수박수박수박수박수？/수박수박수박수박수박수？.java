class Solution {
    public String solution(int n) {
        String answer = "";
        
        for(int i=1; i<=n; i++){
            String a = "수";
            String b = "박";
            
            answer = i%2!=0?answer+a:answer+b;
        }
        
        return answer;
    }
}