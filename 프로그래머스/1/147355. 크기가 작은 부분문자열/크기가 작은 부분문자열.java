class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        String[] s = t.split(""); 
        String a = "";
        long pnum = Long.parseLong(p);
        
        for(int i=0; i<t.length()-p.length()+1; i++){
            for(int j=0; j<p.length(); j++){
                a+=s[i+j];
            }   
             long snum = Long.parseLong(a);
             
            if(snum<=pnum){
                answer++;
            }
            
            a = "";
        }
        
        return answer;
    }
}