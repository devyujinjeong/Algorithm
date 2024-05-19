import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String cal = sc.next();
		
        String[] numArr = cal.split("-|\\+"); // +와 -를 기준으로 문자 자르기
        
        int result = 0;
        int n = numArr.length;
        ArrayList<Integer> num = new ArrayList<Integer>(); // 숫자를 담아두는 arraylist
        ArrayList<Character> sumOrSub = new ArrayList<Character>(); // 기호를 담아두는 arraylist
        
        for (int i=0; i<n; i++) {
        	num.add(Integer.parseInt(numArr[i]));
        }

        for(int i=0; i<cal.length(); i++) {
        	if(cal.charAt(i)=='+'||cal.charAt(i)=='-') {
        		sumOrSub.add(cal.charAt(i));
        	}
        }
        
        while(sumOrSub.contains('+')) {
	        for(int i=0; i<n-1; i++) {
	            if(sumOrSub.get(i)=='+') {
	                num.set(i, num.get(i) + num.get(i + 1));
	                sumOrSub.remove(i); // '+' 문자를 처리한 후 제거
	                num.remove(i + 1); // 이미 더해진 다음 숫자를 제거.
	                n--; // 목록의 크기가 줄어들었으므로 n을 감소
	            }
	        }
        }
        
        if(num.size()==1) {
        	result = num.get(0);
        }else {
        	result = num.get(0);
        	for(int i=1; i<num.size(); i++) {
        		result -= num.get(i);
        	}
        }

        System.out.println(result);
	}

}
