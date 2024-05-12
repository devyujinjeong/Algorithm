import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int k = n%5; 
		int a = n/5;
		
		if (n==1||n==3) {
			System.out.println(-1);
		}else{
			if (k==0) {
				System.out.println(a);
			}else if(k==1||k==4) {
				System.out.println(a+2);
			}else if(k==2) {
				System.out.println(a+1);
			}else if(k==3) {
				System.out.println(a+3);
			}			
		}
	}
}
