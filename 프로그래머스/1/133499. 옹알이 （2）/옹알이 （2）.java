class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<4; j++){
                // 단어가 연속되는 경우를 제외학기 위해서 쓴 부분
                String conti = word[j]+word[j];
                if(babbling[i].contains(word[j])&&!babbling[i].contains(conti)){
                        babbling[i] = babbling[i].replace(word[j],"0");
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