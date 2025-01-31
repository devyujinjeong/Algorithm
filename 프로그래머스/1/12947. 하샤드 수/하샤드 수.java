class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String num = Integer.toString(x);
        char[] array  = num.toCharArray();
        
        int sum = 0;
        
        for(int i=0; i<num.length(); i++){
            sum+=array[i]-48;
        }
        
        answer = x%sum==0?true:false;
        
        return answer;
    }
}