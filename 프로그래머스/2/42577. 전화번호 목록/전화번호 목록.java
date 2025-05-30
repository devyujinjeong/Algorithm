import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();

        for (String number : phone_book) {
            map.put(number, true);
        }

        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (map.containsKey(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}