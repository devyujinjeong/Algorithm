import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int len = numbers.length;
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                hs.add(numbers[i]+numbers[j]);
            }
        }

        int[] answer = new int[hs.size()];
        int i = 0;
        for(int num:hs){
            answer[i++] = num;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}