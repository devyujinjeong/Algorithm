import java.util.*;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;
        int answer = dist.length + 1;

        int[] weak2 = new int[len * 2];
        for (int i = 0; i < len * 2; i++) {
            if (i < len) weak2[i] = weak[i];
            else weak2[i] = weak[i - len] + n;
        }

        List<List<Integer>> permutations = getPermutations(dist);

        for (int start = 0; start < len; start++) {
            for (List<Integer> perm : permutations) {
                int cnt = 1; // 친구 수
                int pos = weak2[start] + perm.get(0); // 첫 번째 친구 커버 범위

                for (int i = start; i < start + len; i++) {
                    if (weak2[i] > pos) {
                        cnt++;
                        if (cnt > dist.length) break;
                        pos = weak2[i] + perm.get(cnt - 1);
                    }
                }

                answer = Math.min(answer, cnt);
            }
        }

        return (answer > dist.length) ? -1 : answer;
    }

    private List<List<Integer>> getPermutations(int[] dist) {
        List<List<Integer>> result = new ArrayList<>();
        permute(dist, 0, result);
        return result;
    }

    private void permute(int[] dist, int depth, List<List<Integer>> result) {
        if (depth == dist.length) {
            List<Integer> list = new ArrayList<>();
            for (int d : dist) list.add(d);
            result.add(new ArrayList<>(list));
        }

        for (int i = depth; i < dist.length; i++) {
            swap(dist, i, depth);
            permute(dist, depth + 1, result);
            swap(dist, i, depth);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}