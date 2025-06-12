class Solution {
    static int answer, N, target;
    static int[] numbers;    
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        N = numbers.length;
        
        backtracking(0, 0);
        
        return answer;
    }
    
    static void backtracking(int depth, int result) {
        if(depth == N) {
            if(result == target) answer++;
            return;
        } else {
            backtracking(depth+1, result+numbers[depth]);
            backtracking(depth+1, result-numbers[depth]);
        }
    }
}