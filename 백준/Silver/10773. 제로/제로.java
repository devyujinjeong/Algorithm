import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int k = sc.nextInt();
    	ArrayList<Integer> stack = new ArrayList<Integer>();
    	
    	for(int i=0; i<k; i++) {
    		int num = sc.nextInt();
    		stack.add(num);
    		if(num==0) {
    			// 숫자가 0일 경우 그 전의 값을 지움   	    	
    			stack.remove(stack.indexOf(0)-1);
    			stack.remove(stack.indexOf(0));
    		}
    	}

    	if(stack.isEmpty()) {
    		System.out.println(0);
    	}
    	else {
    		int stackSum = stack.stream().reduce(0, Integer::sum); 
    		System.out.println(stackSum);
    	}

    }
}