class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] word = s.toCharArray();
        
        // 아스키 코드를 이용해 문제 해결
        for(int i=0; i<word.length; i++){
            // 공백이 아닌 경우만 검사하기 위해서
            if(word[i]!=' '){
                // word[i]를 int로 바꾸고 여기에 n을 저장
                int temp = word[i]+n;
                
                if(word[i]<=90){ // 대문자인 경우
                    if(temp>90&&temp<97){
                        temp -= 26;
                    }else if(temp>=97){
                        temp = word[i]-26+n;
                    }
                }else if(word[i]>=97){ // 소문자인 경우
                    if(temp>122){
                        temp -= 26;
                    }
                }
                word[i] = (char)temp;
            }
            
            answer += word[i];
        }

        return answer;
    }
}