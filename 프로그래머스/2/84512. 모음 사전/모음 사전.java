class Solution {
    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    private static int count = 0;
    private static int result = 0;
    
    public int solution(String word) {
        dfs("", word);
        return result;
    }

    private void dfs(String currentWord, String targetWord) {
        // 단어를 찾으면 해당 인덱스를 저장
        if (currentWord.equals(targetWord)) {
            result = count;
            return;
        }
        
        // 길이가 5를 넘으면 더 이상 탐색하지 않음
        if (currentWord.length() > 5) return;
        
        // 현재 단어가 사전에 추가된 횟수 증가
        count++;
        
        // 모든 모음에 대해 다음 단어 생성
        for (char vowel : VOWELS) {
            dfs(currentWord + vowel, targetWord);
        }
    }
}
