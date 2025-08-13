import java.util.*;

public class Main {
    static final int[] num = {4, 7};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        // 자리수 계산 + 자리수의 최소·최대값 세팅
        long tempA = A, tempB = B;
        int digitA = 0, digitB = 0;
        long minA = 1, minB = 1; // 해당 자리수의 최소값
        while (tempA > 0) { tempA /= 10; digitA++; }
        while (tempB > 0) { tempB /= 10; digitB++; }
        for (int i = 1; i < digitA; i++) minA *= 10;
        for (int i = 1; i < digitB; i++) minB *= 10;

        long count = 0;

        if (digitA == digitB) {
            // 같은 자리수면 한 번만
            count += countLucky(0, 0, digitA, A, B);
        } else {
            // A 자리수 처리
            long endA = (minA * 10) - 1; // 해당 자리수의 최대값
            count += countLucky(0, 0, digitA, A, endA);

            // 중간 자리수 처리
            for (int len = digitA + 1; len <= digitB - 1; len++) {
                long pow2 = 1;
                for (int i = 0; i < len; i++) pow2 *= 2; // 2^len
                count += pow2;
            }

            // B 자리수 처리
            count += countLucky(0, 0, digitB, minB, B);
        }

        System.out.println(count);
    }

    static long countLucky(int currentLen, long currentValue, int targetLen, long start, long end) {
        if (currentLen == targetLen) {
            return (currentValue >= start && currentValue <= end) ? 1 : 0;
        }
        long total = 0;
        for (int d : num) {
            total += countLucky(currentLen + 1, currentValue * 10 + d, targetLen, start, end);
        }
        return total;
    }
}