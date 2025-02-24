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
            
            if (count1 == count2) {
                answer++;
                if (i + 1 < s.length()) {
                    first = s.charAt(i + 1);
                    count1 = 0; 
                    count2 = 0;
                }
            }
        }
        return answer +  (count1 != count2 ? 1 : 0);
    }
}