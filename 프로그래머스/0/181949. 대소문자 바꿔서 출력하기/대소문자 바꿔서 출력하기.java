import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] alpha = new char[a.length()];
        
        for(int i=0; i<a.length(); i++){
            alpha[i] = a.charAt(i);
        }        
        
        for(int i=0; i<a.length(); i++){
            if((int)alpha[i]>=97){
                int num = (int)alpha[i] - 32;
                alpha[i] = (char)num;
            }else{
                int num = (int)alpha[i] + 32;
                alpha[i] = (char)num;
            }
            
            System.out.print(alpha[i]);
        }   
    }
}