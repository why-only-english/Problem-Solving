class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0);
            
        return answer;
    }
    
    // dfs
    public void dfs(int[] numbers, int depth, int target, int sum) {
        // 마지막 노드까지 탐색
        if (depth == numbers.length) {
            if (target == sum) answer++;
        } else {
                // 해당 노드값 더하고 다음 탐색
                dfs(numbers, depth + 1, target, sum + numbers[depth]);
                
                // 해당 노드값 빼고 다음 탐색
                dfs(numbers, depth + 1, target, sum - numbers[depth]);
            }
        }
    }   