import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Score[] scores = new Score[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int korea = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            scores[i] = new Score(name, korea, english, math);
        }

        // 1. 국어 점수 내림차순
        // 2. 국어 점수가 같으면 영어 오름차순
        // 3. 국어, 영어 점수가 같으면 수학 내림차순
        // 4. 이름 기준
        Arrays.sort(scores, (s1, s2) -> {
            if (s1.korea != s2.korea) {
                return s2.korea - s1.korea; // 국어 내림차순
            } else if (s1.english != s2.english) {
                return s1.english - s2.english; // 영어 오름차순
            } else if (s1.math != s2.math) {
                return s2.math - s1.math; // 수학 내림차순
            } else {
                return s1.name.compareTo(s2.name); // 이름 사전순
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Score s : scores) {
            sb.append(s.name).append("\n");
        }
        System.out.print(sb);
    }
}

class Score {
    String name;
    int korea;
    int english;
    int math;

    public Score(String name, int korea, int english, int math) {
        this.name = name;
        this.korea = korea;
        this.english = english;
        this.math = math;
    }
}