class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        // 최대공약수 : 유클리드를 이용해 구현하기
        // 최소공배수 : n*m/최대공약수
        
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        
        int mod = max%min;
        
        while(mod!=0){
            max = min;
            min = mod;
            mod = max%min;
        }
        
        answer[0] = min;
        answer[1] = n*m/min;
        
        return answer;
    }
}