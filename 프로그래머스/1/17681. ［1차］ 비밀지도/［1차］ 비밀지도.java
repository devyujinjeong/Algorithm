class Solution {
    int[][] findBinary(int[] arr) {
        int len = arr.length;
        int[][] newarr = new int[len][len];

        // 입력된 숫자를 2진수로 바꿔서 배열로 보내기
        for (int i = 0; i < len; i++) {
            int num = arr[i];

            // 오른쪽 자리부터 숫자 채우기
            for (int j = len - 1; j >= 0; j--) {
                newarr[i][j] = num % 2;
                num /= 2;
            }
        }
        return newarr;
    }

    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] a = new int[n][n];
        
        // 만약 a[i][j]에 저장된 숫자가 1이상이면, 벽이 있는 것이므로 #을 추가
        // 아니라면 벽이 아예 없는 것이므로 0을 추가
        for(int i=0; i<n; i++){
            String temp = "";
            for(int j=0; j<n; j++){
                a[i][j] = findBinary(arr1)[i][j]+findBinary(arr2)[i][j];
                if(a[i][j]>0){
                    temp+="#";
                }else{
                    temp+=" ";
                }
            }
            answer[i] = temp;

        }


        return answer;
    }
}