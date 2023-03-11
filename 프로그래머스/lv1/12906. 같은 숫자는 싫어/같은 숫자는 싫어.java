import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();  // int형 스택 선언
        
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                if (i == arr.length-2) {  // 마지막 반복일 때
                    stack.push(arr[i]);
                }
                continue;
            } 
            else {
                stack.add(arr[i]);
                if (i == arr.length-2) {  // 마지막 반복일 때
                    stack.push(arr[i+1]);
                }
            }
        }
        
        // 스택에 있는 값 배열에 저장
        int[] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }
}