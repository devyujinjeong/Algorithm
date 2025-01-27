class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int len = numbers.length;
        
        // 1. 숫자들을 다 더하기
        for(int i=0; i<len; i++){
            answer+=numbers[i];
        }

        // 2. answer에 저장된 숫자를 숫자의 개수로 나누기
        answer = answer/len;
        return answer;
    }
}