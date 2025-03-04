import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String runner : callings) {
            int win = map.get(runner);     
            
            String temp = players[win];
            players[win] = players[win - 1];
            players[win - 1] = temp;

            map.replace(players[win], win);
            map.replace(players[win - 1], win - 1);
        }

        return players;
    }
}
