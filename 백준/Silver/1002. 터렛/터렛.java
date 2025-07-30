import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        while (T-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            System.out.println(getCount(x1, y1, r1, x2, y2, r2));
        }

        sc.close();
    }

    public static int getCount(int x1, int y1, int r1, int x2, int y2, int r2) {
        // 두 원 중심 사이의 거리 제곱
        int dx = x1 - x2;
        int dy = y1 - y2;
        int distSq = dx * dx + dy * dy;

        int sumR = r1 + r2;
        int diffR = Math.abs(r1 - r2);

        int sumRSq = sumR * sumR;
        int diffRSq = diffR * diffR;

        if (distSq == 0) {
            if (r1 == r2) return -1; // 완전히 겹침
            else return 0;           // 중심은 같지만 반지름 다름 → 접점 없음
        }

        if (distSq > sumRSq) return 0;      // 멀어서 안 만남
        else if (distSq == sumRSq) return 1; // 외접
        else if (distSq < diffRSq) return 0; // 한 원이 안쪽에 있음 (접점 없음)
        else if (distSq == diffRSq) return 1; // 내접
        else return 2; // 두 점에서 만남
    }
}