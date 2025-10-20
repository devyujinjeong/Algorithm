import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Time[] rooms = new Time[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            rooms[i] = new Time(start,end);
        }

        Arrays.sort(rooms, (a, b) -> {
            if (a.end == b.end) return Long.compare(a.start, b.start);
            return Long.compare(a.end, b.end);
        });

        long cur = 0;
        int count = 0;
        int i = 0;
        while(i<N) {
            if(cur<=rooms[i].start) {
                cur = rooms[i].end;
                count++;
            }

            i++;

        }

        System.out.println(count);
    }

    static class Time {
        long start;
        long end;

        public Time(long start, long end){
            this.start = start;
            this.end = end;
        }
    }
}