import java.util.*;

class Solution {
    // 1. 소수 판정 메소드 구현하기
    static boolean isPrime(int num) {
        // 만약 num의 제곱근보다 작거나 같은 자연수(2부터 시작) 그 무엇으로도 나눠지지 않으면
        // prime임을 이용
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int solution(int[] nums) {
        int n = nums.length;
        int answer = 0;

        // 3개의 숫자 조합을 만들어 소수 판정하기 
        // case 크기가 크지 않아서 그냥 이렇게 써도 될듯
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
