import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int w = Integer.parseInt(st.nextToken()); 
        int l = Integer.parseInt(st.nextToken()); 

        Queue<Integer> truckWeight = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truckWeight.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
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

        System.out.println(time + w); // 마지막 트럭이 다리를 빠져나가는 시간 추가
    }
}
