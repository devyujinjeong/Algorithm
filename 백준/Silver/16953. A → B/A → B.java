import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count = 1;
		int c = b%10;
		
		while (a<b) {
			if(b%2==0) {
				b=b/2;
				c = b%10;
				count++;
				if(a>b) {count =-1;}
			}else if(c==1) {
				b=b/10;
				count++;
				if(a>b) {count =-1;}
			}else {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}
}
