import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] classes = new int[n][2];

        for (int i = 0; i < n; i++) {
            classes[i][0] = sc.nextInt();
            classes[i][1] = sc.nextInt();
        }

        // 시작 시간을 기준으로 정렬하기
        Arrays.sort(classes, (a, b) -> a[0] - b[0]);

        // 끝나는 시간 정렬
        PriorityQueue<Integer> classCount = new PriorityQueue<>();

        classCount.add(classes[0][1]);

        for (int i = 1; i < n; i++) {
            if (classes[i][0] >= classCount.peek()) {
            	classCount.poll();
            }
            classCount.add(classes[i][1]);
        }

        System.out.println(classCount.size());
    }
}
