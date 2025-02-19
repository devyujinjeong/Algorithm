import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int stageLen = stages.length;
        int temp = stageLen;
        float[][] checkFail = new float[N][2];  // 0: 실패율, 1: 스테이지 번호
        
        // 스테이지 배열 정렬
        Arrays.sort(stages);

        // 실패율 계산
        int index = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            while (index < stageLen && stages[index] == i) {
                count++;
                index++;
            }

            if (temp == 0) {
                checkFail[i - 1][0] = 0;  // 실패율이 0인 경우
            } else {
                checkFail[i - 1][0] = (float) count / temp;
            }
            checkFail[i - 1][1] = i;  // 스테이지 번호
            temp -= count;  // 남은 스테이지 수
        }

        // 실패율 기준 내림차순 정렬
        Arrays.sort(checkFail, new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                // 실패율이 같으면 스테이지 번호 기준으로 오름차순 정렬
                if (o1[0] == o2[0]) {
                    return Float.compare(o1[1], o2[1]);
                }
                return Float.compare(o2[0], o1[0]);  // 실패율 기준 내림차순
            }
        });

        // 정렬된 결과를 answer 배열에 넣기
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) checkFail[i][1];
        }

        return answer;
    }
}
