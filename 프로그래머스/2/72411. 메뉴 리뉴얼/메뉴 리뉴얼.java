import java.util.*;

class Solution {
    static HashMap<String, Integer> menu;

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for (int len : course) {
            menu = new HashMap<>();

            // 각 주문마다 조합 구하기
            for (String order : orders) {
                char[] temp = order.toCharArray();
                Arrays.sort(temp);  
                combine(temp, 0, len, "");
            }

            int max = 0;
            for (int count : menu.values()) {
                if (count >= 2) {
                    max = Math.max(max, count);
                }
            }

            for (String key : menu.keySet()) {
                if (menu.get(key) == max && max >= 2) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    static void combine(char[] letters, int start, int r, String current) {
        if (current.length() == r) {
            menu.put(current, menu.getOrDefault(current, 0) + 1);
            return;
        }

        for (int i = start; i < letters.length; i++) {
            combine(letters, i + 1, r, current + letters[i]);
        }
    }
}
