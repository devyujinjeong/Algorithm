import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int sum = 0;
        // 기호를 저장한 배열
        String[] splitWord = dartResult.split("10|[0-9]");      
        // 숫자를 저장한 배열
        String[] splitNum = dartResult.split("[SDT*#]");      
        splitNum = Arrays.stream(splitNum)
                 .map(String::trim) 
                 .filter(s -> !s.isEmpty()) 
                 .toArray(String[]::new);       

        int prev = 0;
        for(int i=1; i<splitWord.length; i++){
            int temp = Integer.parseInt(splitNum[i-1]);
            for(int j=0; j<splitWord[i].length(); j++){
                char c = splitWord[i].charAt(j);
                
                switch(c){
                    case 'S':
                        break;
                    case 'D':
                        temp = (int)Math.pow(temp,2);
                        break;
                    case 'T':
                        temp = (int)Math.pow(temp,3);
                        break;
                    case '*':
                        temp *= 2;
                        sum += prev;
                        break;

                    case '#':
                        temp *=-1;
                        break;
                }
            }  
            sum+=temp;
            prev = temp;
        }
        
        
        return sum;
    }
}