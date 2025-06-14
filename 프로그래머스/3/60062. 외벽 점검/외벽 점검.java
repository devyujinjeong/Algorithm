import java.util.*;

// 백트래킹을 이용해 친구들의 조합을 구하고
// 친구를 확인해 보면서 취약 지점을 커버 가능한지 확인 하는 것
class Solution {
    static int n, distLen, answer;
    static int[] weak2;

    public int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;
        this.n = n;
        distLen = dist.length;
        answer = distLen + 1;

        // 1. weak를 확장함 : 시계, 반시계 방향이 존재하기 때문에 직선으로 확장해서 두 가지 방향을 다 커버
        weak2 = new int[len * 2];
        
        for (int i = 0; i < len * 2; i++) {
            weak2[i] = (i < len) ? weak[i] : weak[i - len] + n;
        }

        // 2. dist의 모든 순열 구하기 : 친구들의 조합 구하기
        List<List<Integer>> permutations = getPermutations(dist);

        // 3. 각 조합으로 커버 가능한 경우 구하기
        for (int start = 0; start < len; start++) {
            // 만약 dist가 [1,2,3]인 경우에
            // perm에는 [1,2,3], [1,3,2] .... 이런식으로 저장되어 있음!
            for (List<Integer> perm : permutations) {
                int cnt = 1;
                
                // 취약점의 위치 + 커버할 수 있는 거리 = 1번째 친구가 커버할 수 있는 거리
                int pos = weak2[start] + perm.get(0);

                // 각 취약지점을 커버할 수 있는지 확인
                for (int i = start; i < start + len; i++) {
                    // 밑에 같은 경우가 발생한다는 것은 아직 취약 지점을 다 커버하지 못했다는 것
                    if (weak2[i] > pos) {
                        // 인원 수를 1명 더 늘리기
                        cnt++;
                        // 만약 cnt가 친구의 수보다 커진다면 끝...! 결국 커버할 수 없다는 의미이므로
                        if (cnt > distLen) break;
                        
                        // 새로운 친구가 커버할 수 있는지 업데이트 하기
                        pos = weak2[i] + perm.get(cnt - 1);
                    }
                }

                answer = Math.min(answer, cnt);
            }
        }

        return (answer > distLen) ? -1 : answer;
    }

    // 친구의 모든 조합을 찾는 메서드친구의 모든 조합을 찾는 메서드
    private static List<List<Integer>> getPermutations(int[] dist) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[dist.length];
        backtrack(dist, visited, new ArrayList<>(), result);
        return result;
    }

    // 친구의 조합을 구하는 백트래킹 메소드
    private static void backtrack(int[] dist, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == distLen) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(dist[i]);
                backtrack(dist, visited, current, result);
                current.remove(current.size() - 1); // 다시 원 상태로 돌리기 (백트래킹)
                visited[i] = false;
            }
        }
    }
}
