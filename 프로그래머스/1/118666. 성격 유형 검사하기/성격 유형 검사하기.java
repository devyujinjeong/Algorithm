class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
                
        // 앞에 있는 단어의 답이 나오면 +, 아니면 - 하기
        String[] type = {"RT", "CF", "JM", "AN"};
        int[] score = {0,0,0,0};
        
        for(int i=0; i<survey.length; i++){
            if(survey[i].equals("RT")) score[0] += 4-choices[i];
            if(survey[i].equals("CF")) score[1] += 4-choices[i];
            if(survey[i].equals("JM")) score[2] += 4-choices[i];
            if(survey[i].equals("AN")) score[3] += 4-choices[i];
            
            if(survey[i].equals("TR")) score[0] += choices[i]-4;
            if(survey[i].equals("FC")) score[1] += choices[i]-4;
            if(survey[i].equals("MJ")) score[2] += choices[i]-4;
            if(survey[i].equals("NA")) score[3] += choices[i]-4;
        }
        
        for(int i=0; i<4; i++){
            if(score[i]>=0){
                answer+=type[i].charAt(0);
            }else{
                answer+=type[i].charAt(1);
            }   
        }
        
        return answer;
    }
}