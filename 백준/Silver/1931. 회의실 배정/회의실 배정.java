import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 회의의 개수와 시간 입력하기
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        int count = 0;
        int endTime = 0;

        // 끝나는 시간을 기준으로 정렬하기
        Arrays.sort(meetings, (o1, o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));

        // 종료 시간이 가장 빠른 회의부터 선택해서 최대 회의 수 찾기
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= endTime) { // 회의 시작 시간이 이전 회의 종료 시간보다 크거나 같다면
                endTime = meetings[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
