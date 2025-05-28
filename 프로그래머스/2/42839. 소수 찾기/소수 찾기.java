import java.util.*;

class Solution {
    static HashSet<Integer> hs = new HashSet<>(); 
    
    public int solution(String numbers) {
        char[] chars = numbers.toCharArray();
        boolean[] visited = new boolean[chars.length];

        dfs(chars, visited, "", 0);

        int count = 0;
        for (int num : hs) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    void dfs(char[] chars, boolean[] visited, String current, int depth) {
        if (!current.equals("")) {
            hs.add(Integer.parseInt(current));
        }

        if (depth == chars.length) return;

        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(chars, visited, current + chars[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
