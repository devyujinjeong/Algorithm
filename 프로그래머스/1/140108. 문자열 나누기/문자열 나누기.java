class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char first = s.charAt(0);
        int count1 = 0;
        int count2 = 0;
        for(int i=0 ; i<s.length(); i++){          
            if(first == s.charAt(i)){
                count1++;
            }else{
                count2++;
            }
            
            if(count1==count2){
                if(i!=s.length()-1){
                    first = s.charAt(i+1);
                }
                count1 = 0;
                count2 = 0;
                answer++;
            }else{
                // 만약에 마지막 상황인데 count1과 count2가 같지 않다면 answer++
                if(i==s.length()-1){
                    answer++;
                }
            }
        }
        return answer;
    }
}