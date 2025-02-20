class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        
        // 연속되는 경우만 제외해주기
        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<4; j++){
                if(babbling[i].contains(word[j])){
                    String conti = word[j]+word[j];
                    if(babbling[i].contains(conti)){
                        babbling[i] = babbling[i].replace(word[j],"1");
                    }else{
                        babbling[i] = babbling[i].replace(word[j],"0");
                    }  
                }
            }
            babbling[i] = babbling[i].replace("0","");
            if(babbling[i].length()==0){
                answer++;
            }
        }
        
        
        return answer;
    }
}