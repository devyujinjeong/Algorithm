class Solution {
    public String solution(String new_id) {        
        // 1~3 단계
        new_id = new_id.toLowerCase()
               .replaceAll("[^a-z0-9-_.]", "")
               .replaceAll("\\.{2,}", ".");
        
        System.out.println(new_id);
        int len = new_id.length();
        
        // 4단계
        if (!new_id.isEmpty() && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
            len--;
        }

        if (!new_id.isEmpty() && new_id.charAt(len - 1) == '.') {
            new_id = new_id.substring(0, len - 1);
            len--;
        }

        // 5단계
        if(new_id.isEmpty()) {
            new_id+="a";
            len = 1;
        }
        
        // 6단계
        if(len>=16){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(14)=='.'){
                new_id = new_id.substring(0,14);
            }
        }
        
        // 7단계
        while (len < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
            len++;
        }
        
        return new_id;
    }
}