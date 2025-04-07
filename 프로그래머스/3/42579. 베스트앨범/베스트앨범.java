import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 수 저장
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 2. 장르별 노래 리스트 저장 (노래는 [고유번호, 재생수])
        Map<String, List<int[]>> genreToSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르 총 재생수 더하기
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            // 장르별 노래 리스트에 추가
            if (!genreToSongs.containsKey(genre)) {
                genreToSongs.put(genre, new ArrayList<>());
            }
            genreToSongs.get(genre).add(new int[]{i, play});
        }

        // 3. 장르를 재생수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> answer = new ArrayList<>();

        // 4. 각 장르별로 재생수 많은 노래 2개 선택
        for (String genre : sortedGenres) {
            List<int[]> songs = genreToSongs.get(genre);
            // 재생수 내림차순, 같으면 고유번호 오름차순
            songs.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1]; // 재생수 기준
                return a[0] - b[0]; // 고유번호 기준
            });

            // 최대 2곡까지 추가
            for (int i = 0; i < songs.size() && i < 2; i++) {
                answer.add(songs.get(i)[0]);
            }
        }

        // 결과를 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
