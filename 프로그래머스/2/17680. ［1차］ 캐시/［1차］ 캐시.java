import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> cache = new ArrayDeque<>();

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.remove(city)) {
                answer += 1;
            } else {
                answer += 5;
                if (cacheSize > 0 && cache.size() == cacheSize) {
                    cache.pollFirst(); // 맨 앞에 있는 오래된 거 제거
                }
            }
            if (cacheSize > 0) {
                cache.offerLast(city); // 맨 뒤에 새로 넣기
            }
        }

        return answer;
    }
}
