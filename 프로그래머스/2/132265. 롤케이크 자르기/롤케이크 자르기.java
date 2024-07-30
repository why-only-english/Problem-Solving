import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> first = new HashMap<>(); 
        Map<Integer, Integer> second = new HashMap<>(); 
        
        for (int e : topping) {
            second.put(e, second.getOrDefault(e, 0) + 1);
        }
        
        for (int e : topping) {
            first.put(e, first.getOrDefault(e, 0) + 1);
            
            if (second.get(e) - 1 == 0)
                second.remove(e);
            else
                second.put(e, second.get(e) - 1);  
            
            if (first.size() == second.size())
                answer++;
        }

        return answer;
    }
}