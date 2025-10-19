class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String allNum = "";
        
        for(int i=0; i<=t*m; i++) {
            allNum+=convertToBase(i, n);
        }
        
        for(int i=0; i<allNum.length(); i++) {
            if(i%m==p-1) {
                answer+=allNum.charAt(i);   
                t--;
            }
                    
            if(t==0) break;
        }
        
        return answer;
    }
    
    static String convertToBase(int num, int base) {
        if (num == 0) return "0";
        
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            int remainder = num % base;
            sb.append(digits.charAt(remainder)); // 나머지에 해당하는 문자 추가
            num /= base;
        }
        
        return sb.reverse().toString(); // 뒤집어서 반환
    }
}