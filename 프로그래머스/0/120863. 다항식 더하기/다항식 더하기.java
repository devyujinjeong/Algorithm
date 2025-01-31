class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] n = polynomial.split("\\s*\\+\\s*"); 
        int a = 0;
        int b = 0;
        
        for (int i = 0; i < n.length; i++) {
            if(n[i].contains("x")){
                if(n[i].equals("x")){
                    a++;
                }else{
                    a += Integer.parseInt(n[i].replace("x", ""));
                }
            }else{
                b+=Integer.parseInt(n[i]);
            }
        }
        
        if(b==0){
            if(a==1){
                answer = "x";
            }else{
                answer = a+"x";    
            }
        }else{
            if(a==1){
                answer = "x + "+b;
            }else if(a==0){
                 answer = Integer.toString(b);
            }else{
                answer = a+"x + "+b; 
            }
        }
        
        return answer;
    }
}