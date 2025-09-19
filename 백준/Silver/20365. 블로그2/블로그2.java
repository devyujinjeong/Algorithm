import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String color = br.readLine();

        int blue = 0; // 파란색 묶음
        int red = 0; // 빨간색 묶음

        // 1. 연속하는 색끼리 묶음 만들기 : 이게 기준이 됨
        char before = color.charAt(0);
        if(before == 'B') blue++;
        else red++;

        for(int i=1; i<color.length(); i++) {

            if(before == color.charAt(i)) continue;
            else {
                if(color.charAt(i) == 'B') blue++;
                else red++;
            }

            before = color.charAt(i);
        }

        int min = Math.min(blue, red);

        System.out.println(min+1);

    }
}