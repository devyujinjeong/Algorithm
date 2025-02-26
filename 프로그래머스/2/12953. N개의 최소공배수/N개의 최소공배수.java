class Solution {
    // 유클리드 호제법 이용하기
    int findGcd(int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int mod = max%min;
        
        while(mod!=0){
            max = min;
            min = mod;
            mod = max%min;
        }
        
        return min;        
    }
    
    int findLcm(int a, int b){
        // 최소공배수 = A*B/최대공약수 
        int lcm = a*b/findGcd(a,b);    
        return lcm;     
    }
    
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++){
            answer = findLcm(answer, arr[i]);
        }
        
        return answer;
    }
}