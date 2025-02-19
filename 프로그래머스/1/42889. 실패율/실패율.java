import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int stageLen = stages.length;
        int temp = stageLen;
        float[][] checkFail = new float[N][2];  
        
        Arrays.sort(stages);

        int index = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            while (index < stageLen && stages[index] == i) {
                count++;
                index++;
            }

            if (temp == 0) {
                checkFail[i - 1][0] = 0; 
            } else {
                checkFail[i - 1][0] = (float) count / temp;
            }
            checkFail[i - 1][1] = i; 
            temp -= count; 
        }

        Arrays.sort(checkFail, new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                if (o1[0] == o2[0]) {
                    return Float.compare(o1[1], o2[1]);
                }
                return Float.compare(o2[0], o1[0]);  
            }
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) checkFail[i][1];
        }

        return answer;
    }
}
