class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;

        // 밑의 계산을 했을 때, 숫자가 같아지는 순간 전 단계가 둘이 대결한 라운드
        while(a!=b){
            a = (a+1)/2;
            b = (b+1)/2;
            
            answer++;
        }
        
        return answer;
    }
}