import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 회의의 개수와 시간 입력하기
        int n = sc.nextInt();
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt(); // 시작 시간
            meetings[i][1] = sc.nextInt(); // 종료 시간
        }
        
        Arrays.sort(meetings, (o1, o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= endTime) { // 회의 시작 시간이 이전 회의 종료 시간보다 크거나 같다면
                endTime = meetings[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}