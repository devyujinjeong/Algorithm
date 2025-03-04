import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);  // index 저장
        }

        for (String runner : callings) {
            int win = map.get(runner);  
            
            if (win == 0) continue;  // 맨 앞이면 넘어감
            
            String temp = players[win];
            players[win] = players[win - 1];
            players[win - 1] = temp;

            map.put(players[win], win);
            map.put(players[win - 1], win - 1);
        }

        return players;
    }
}
