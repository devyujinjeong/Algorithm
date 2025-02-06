class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray(); 
        String answer = "";
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                answer += " ";
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    answer += Character.toUpperCase(arr[i]);
                } else {
                    answer += Character.toLowerCase(arr[i]);
                }
                idx++;
            }
        }

        return answer;
    }
}
