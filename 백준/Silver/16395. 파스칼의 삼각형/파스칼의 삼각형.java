import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] pascal = new int[r + 1][r + 1];

        // 파스칼 삼각형 구성
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    pascal[i][j] = 1;  // 맨 처음과 끝은 1
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
        }

        System.out.println(pascal[r][c]);
    }
}
