import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 최대
        int max = nums.length / 2;
        // System.out.println(nums.length);
        
        // 포켓몬 종류 중복제거
        HashSet <Integer> type = new HashSet<>();
        
        for (int num : nums) {
            type.add(num);
        }
        
        if (type.size() >= max) {
            return max;
        } else {
            return type.size();
        }
    }
}