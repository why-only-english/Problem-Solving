import java.util.*;

class Solution {
    // 반환 타입 바꿔버리기
    public ArrayList<Integer> solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // 정렬
        ArrayList<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);
        
        return answer;
    }
}