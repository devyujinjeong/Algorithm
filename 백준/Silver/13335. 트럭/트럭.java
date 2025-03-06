import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); 
        int w = sc.nextInt();
        int l = sc.nextInt();
        
        Queue<Integer> truckWeight = new LinkedList<>(); // 대기 중인 트럭
        for (int i = 0; i < n; i++) {
            truckWeight.add(sc.nextInt());
        }

        Queue<Integer> bridge = new LinkedList<>(); // 다리 위의 상태
        int time = 0;
        int sum = 0;

        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        while (!truckWeight.isEmpty()) {
            sum -= bridge.poll();

            if (!truckWeight.isEmpty() && sum + truckWeight.peek() <= l) {
                int newTruck = truckWeight.poll();
                bridge.add(newTruck);
                sum += newTruck;
            } else {
                bridge.add(0); 
            }

            time++;
        }

        System.out.println(time + w); 
    }
}