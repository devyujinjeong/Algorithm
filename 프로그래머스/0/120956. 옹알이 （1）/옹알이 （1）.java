class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] baby = {"aya", "ye", "woo", "ma"};
                
        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<4; j++){
                // babbling[i]에서 baby[j]와 일치하는 단어가 있다면 "0"으로 바꾸기
                if(babbling[i].contains(baby[j])){
                    babbling[i] = babbling[i].replace(baby[j],"0");   
                }     
            }
            
            // 위에서 "0"으로 바꾼 단어와 babbling에 저장된 단어가 일치하면 answer +1 하기
            String temp = "";
            for(int k=0; k<babbling[i].length(); k++){
                temp+="0";
            }

            if(temp.equals(babbling[i])){
                answer++;
            }     
        }
            
        return answer;
    }
}