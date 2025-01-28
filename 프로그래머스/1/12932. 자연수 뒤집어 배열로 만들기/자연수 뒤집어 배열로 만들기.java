class Solution {
    public int[] solution(long n) {
        // 1. n을 string으로 변환하기
        // 2. 1에서 변환한 값을 배열에 거꾸로 저장하기 + int로 형변환
        String num = Long.toString(n);
        int len = num.length();
        
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            answer[i] = num.charAt(len-i-1)-48;
        }

        return answer;
    }
}