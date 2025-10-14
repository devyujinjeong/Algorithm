import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;        
        int digit = 0; 
        int temp = n;
        
        while(temp>0) {
            digit++;
            temp/=k;
        }
        
        String s = "";
        for(int i=digit-1; i>=0; i--) {
            int cur = (int)Math.pow(k,i);
            int num = n/cur;
            n-=cur*num;
            s+=num;
        }
        
        String[] sarr = s.split("0+");
        
        for(int i=0; i<sarr.length; i++) {
            if(isPrime(sarr[i])) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(String s) {
        long temp = Long.parseLong(s);
        
        if(temp==1) return false;
        
        for(int i=2; i<=(int)Math.sqrt(temp); i++) {
            if(temp%i==0) {
                return false;
            }
        }
    
        return true;
    }
}