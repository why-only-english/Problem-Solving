import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int leftInt = (int)left;
        int rightInt = (int)right;
        
        int len = rightInt - leftInt;
        int[] answer = new int[len + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[idx++] = Math.max((int)row, (int)col) + 1;
        }
        
        // for (int i = 0; i < 10; i++) {
        //     System.out.print("row = " + (i / 3) + ", ");
        //     System.out.println("col = " + (i % 3));
        // }
        
        return answer;
    }
}