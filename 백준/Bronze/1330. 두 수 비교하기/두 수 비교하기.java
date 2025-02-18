import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String answer = "";
        
        if(a>b){
            answer = ">";
        }else if(a<b){
            answer = "<";
        }else{
            answer = "==";
        }
        
        System.out.println(answer);
    }
}