import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // 이전에 등장했던 단어인지를 확인하기 위해서 Set 이라는 자료형을 사용
        Set<String> allWords = new HashSet<>();
    
        // 첫 번째 단어 넣기
        allWords.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            // 만약 앞에 나온 단어라면
            if(allWords.contains(words[i])){
                answer[0] = i%n+1; // 몇 번째 사람이
                answer[1] = i/n+1; // 몇 번째 차례에서 
                break;
            }else{
                // 끝나는 글자와 시작하는 글자가 다르다면
                if(words[i].charAt(0)!=words[i-1].charAt(words[i-1].length()-1)){
                    answer[0] = i%n+1;
                    answer[1] = i/n+1; 
                    break;
                }else{
                    allWords.add(words[i]);   
                }
            }            
        }
        
        // 만약 이 for문을 다 통과하지 않는다면 끝말잇기가 성공한 것으므로
        // 초기값인 [0,0]을 반환
        return answer;
    }
}