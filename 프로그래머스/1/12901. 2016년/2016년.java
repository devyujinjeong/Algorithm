class Solution {
    public String solution(int a, int b) {
        String[] week = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] dayOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        int totalDay = b;
        for(int i=0; i<a-1; i++){
            totalDay+=dayOfMonth[i];
        }

        return week[totalDay%7];

    }
}