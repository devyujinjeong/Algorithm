import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {-1, 1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            int count = 0;
            int[][] land = new int[h+1][w+1];

            for(int i=1; i<=h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <=w; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=1; i<=h; i++) {
                for(int j=1; j<=w; j++) {
                    if(land[i][j] == 1) {
                        count++;
                        dfs(land, i, j, w, h);
                    }
                }
            }

            System.out.println(count);

        }
    }

    static void dfs(int[][] land, int i, int j, int w, int h) {
        if(land[i][j] == 0) return;

        land[i][j] = 0;
        for(int x =0; x<8; x++) {
            for(int y=0; y<8; y++) {
                int tempX = i+dx[x];
                int tempY = j+dy[y];

                if(tempX<1 || tempX>h ||tempY<1 || tempY>w) continue; // 범위에서 넘어가는 경우

                if(land[tempX][tempY]==0) continue;

                dfs(land, tempX, tempY, w, h);
            }
        }
    }
}