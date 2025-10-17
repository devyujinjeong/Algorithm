class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            long x = n + 1;
            long y = (n ^ x) >>> 2;
            answer[i] = x + y;
        }
        return answer;
    }
}
