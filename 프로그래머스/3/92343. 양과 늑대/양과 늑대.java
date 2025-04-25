import java.util.*;

class Solution {
    // 현재 위치, 양의 수, 늑대의 수, 방문 내역을 기록
    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;
        
        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }
    
    private static ArrayList<Integer>[] tree;
    static int answer;
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        tree = new ArrayList[info.length];
        for(int i=0; i<tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // 연결 관계 저장하기
        for(int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
        
        ArrayDeque<Info> queue = new ArrayDeque<>();
        // 루트 노드는 항상 양이기 때문에 1추가
        queue.add(new Info(0, 1, 0, new HashSet<>()));
    
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            Info now = queue.poll();
            // answer과 현재 양의 수 중 더 큰 값을 pick 하기
            answer = Math.max(answer, now.sheep);
            // 방문한 노드를 저장하는 배열에 현재 노드의 이웃 노드 추가
            // 다음에 방문할 노드들의 정보가 들어있는 것!
            now.visited.addAll(tree[now.node]);
            
            // 인접한 노드에 대해서 탐색하기
            // visited는 현재까지 방문한 노드
            for(int next : now.visited) {
                // 기존 hashset에 데이터를 복사
                HashSet<Integer> set = new HashSet<>(now.visited);
                // 현재 방문한 정점을 제거하기
                set.remove(next);
                
                if(info[next] == 1) { // 만약 늑대라면
                    // 양과 늑대의 수가 다른 경우에만
                    if(now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf+1, set));
                    }
                } else { // 만약 양이라면 무조건 방문하기
                    queue.add(new Info(next, now.sheep+1, now.wolf, set));
                }
            }
        }
        
        return answer;
    }

}