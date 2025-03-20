import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer =  new ArrayList<Integer>();

        String[] repeating = {"12345","21232425","3311224455"};
        int[] correct = new int[3];
        int max = 0;
        
        for(int j=0; j<3; j++){
            int len = repeating[j].length();
            for(int i=0; i<answers.length; i++){
                if(answers[i]==repeating[j].charAt(i%len)-48){
                    correct[j]++;
                }
            }
            
            if(max<correct[j]){
                max = correct[j];
            }
        }
        
        for(int i=0; i<3; i++){
            if(correct[i]==max){
                answer.add(i+1);
            }
        }        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}