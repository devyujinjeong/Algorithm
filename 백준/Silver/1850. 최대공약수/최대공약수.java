import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long mod = b % a;
        
        while (mod != 0) {
            b = a;
            a = mod;
            mod = b % a;
        }       
        
        for (int i = 0; i < a; i++) {
        	bw.write("1");
        }
       
        bw.flush();
        bw.close();    
     }
}