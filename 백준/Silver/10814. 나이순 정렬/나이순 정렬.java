import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members[i] = new Member(age, name, i);
        }

        Arrays.sort(members, (m1, m2) -> {
            if(m1.age != m2.age) {
                return m1.age - m2.age;
            } else {
                return m1.joining - m2.joining;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Member m: members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.print(sb);
    }
}

class Member {
    int age;
    String name;
    int joining;

    public Member(int age, String name, int joining) {
        this.age = age;
        this.name = name;
        this.joining = joining;
    }
}