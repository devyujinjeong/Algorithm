class Solution {
    public long solution(String s) { 
        long answer = 0;
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<num.length; i++){
            String temp = num[i];
            if(s.contains(temp)){
                s = s.replaceAll(temp,Integer.toString(i));
            }
            
            if(s.length()==0){
                break;
            }
        }
         
        answer = Long.parseLong(s);
        return answer;
    }
}