import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;    
        } 
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        for (int i = 2; i < 9; i++) {
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(num);
            
            for (int j = 1; j < i; j++) {
                for (int op1 : dp.get(j)) {
                    for (int op2 : dp.get(i - j)) {
                        dp.get(i).add(op1 + op2);
                        dp.get(i).add(op1 - op2);
                        dp.get(i).add(op1 * op2);
                        if (op2 != 0) dp.get(i).add(op1 / op2);
                    }
                }
            }
            
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}
