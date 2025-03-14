class Solution {
    public int solution(int n) {
        int answer = 0;
                
        int a = Integer.bitCount(n);
        
        while(true){
            n++;
            int b = Integer.bitCount(n);
            if(a==b){
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}
