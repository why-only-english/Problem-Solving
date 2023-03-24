import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int cnt = commands.length;  // answer 배열 원소 개수
        int[] answer = {};
        int[] ans = new int[cnt];
        
        for(int i = 0; i < cnt; i++) {
            // 배열 자르기
            answer = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            // 정렬
            Arrays.sort(answer);
            // k번째에 있는 수 저장
            ans[i] = answer[commands[i][2]-1];    
        }
        
        return ans;
    }
}