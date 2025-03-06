import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        System.out.println(josephus(n, k));
    }

    public static String josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            result.add(queue.poll());
        }

        return result.toString().replace("[", "<").replace("]", ">");
    }
}