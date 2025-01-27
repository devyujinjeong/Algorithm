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
            if(alpha[i]>=97){
                alpha[i] = (char)(alpha[i] - 32);
            }else{
                alpha[i] = (char)(alpha[i] + 32);
            }
            
            System.out.print(alpha[i]);
        }   
    }
}