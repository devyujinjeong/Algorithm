import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = Math.min(a,b);
        int max = Math.max(a,b);

        ArrayList<Integer> arr = new ArrayList<>();

        int gcd = 1;

        for(int i=1; i<=Math.sqrt(min); i++) {
            if(min%i==0) {
                arr.add(i);
                arr.add(min/i);
            }
        }

        Collections.sort(arr);

        for(int num : arr) {
            if(max%num==0) {
                gcd = num;
            }
        }

        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }
}