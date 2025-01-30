class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        String[] my = rsp.split("");
        String[] a = {"2","0","5"};
        String[] b = {"0","5","2"};
        
        for(int i=0; i<my.length; i++){
            for(int j=0; j<3; j++){
                if(my[i].equals(a[j])){
                    answer+=b[j];
                }
            }
        }
        
        return answer;
    }
}