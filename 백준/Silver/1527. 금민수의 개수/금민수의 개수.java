import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A,B;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        findNum(0);
        System.out.println(count);
    }

    static void findNum(long cur){
        if(cur>=A && cur<=B) count++;

        if(cur>B) return;

        findNum(cur*10+4); // 숫자 4를 뒤에 붙이기
        findNum(cur*10+7); // 숫자 7을 뒤에 붙이기
    }
}