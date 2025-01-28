class Solution {
    public int[] solution(long n) {
        // 1. n을 string으로 변환하기
        // 2. 1에서 변환한 값을 char형태로 분리해서 배열에 저장하기
        // 3. char의 경우 int로 자동형변환이 됨. 그리고 '1'은 49를 의미
        String num = Long.toString(n);
        int len = num.length();
        
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            answer[i] = num.charAt(len-i-1)-48;
        }

        return answer;
    }
}