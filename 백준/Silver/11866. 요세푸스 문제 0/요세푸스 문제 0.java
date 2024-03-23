import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사람 수
        int n = sc.nextInt();
        // 죽는 사람 번호 간격
        int k = sc.nextInt();

        ArrayList<Integer> death = new ArrayList<>(); // 생존자 리스트
        ArrayList<Integer> deadOrder = new ArrayList<>(); // 죽는 사람 순서를 저장할 리스트

        // 생존자 리스트에 사람들의 번호 추가
        for (int i = 1; i <= n; i++) {
            death.add(i);
        }

        int killIndex = 0; // k번째 사람을 가리킬 인덱스

        // 한 명이 남을 때까지 반복
        while (death.size() > 0) {
            killIndex = (killIndex + k - 1) % death.size(); // k번째 사람의 인덱스 계산
            deadOrder.add(death.remove(killIndex)); // 죽는 사람 순서에 추가하고 죽은 사람 제거
        }

        // 죽는 사람 순서 출력
        System.out.print("<");
        for (int i = 0; i < deadOrder.size(); i++) {
            System.out.print(deadOrder.get(i));
            if (i != deadOrder.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");

    }
}