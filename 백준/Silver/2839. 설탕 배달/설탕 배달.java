import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		int N = Integer.parseInt(br.readLine());
		int bagNum = 0;
		
		while(N%5>0) {
			N-=3;
			bagNum++;
		}
		
		if(N<0) {System.out.println(-1);}
		else {
			bagNum+=N/5;
			System.out.println(bagNum);
		} 
    }
}