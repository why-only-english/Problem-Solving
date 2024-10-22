import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();
        int currentLeft = 10; 
        int currentRight = 12; 
                
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if (num == 0) {
                num = 11; 
            }
            
            // 1, 4 ,7
            if (num % 3 == 1) {
                currentLeft = num;
                result.append("L");
            }
            // 3, 6, 9
            else if (num % 3 == 0) {
                currentRight = num;
                result.append("R");
            }
            // 2, 5, 8, 0
            else {
                int distLeft = getDistance(currentLeft, num);
                int distRight = getDistance(currentRight, num);
                
                if (distLeft < distRight) {
                    currentLeft = num;
                    result.append("L");
                } else if (distLeft > distRight) {
                    currentRight = num;
                    result.append("R");
                } else {
                    if (hand.equals("right")) {
                        currentRight = num;
                        result.append("R");
                    } else {
                        currentLeft = num;
                        result.append("L");
                    }
                }
            }
        }
        return result.toString();
    }
    
    private int getDistance(int pos, int target) {
        if (pos == 0) pos = 11;
        if (target == 0) target = 11;
        
        int posX = (pos - 1) / 3;
        int posY = (pos - 1) % 3;
        int targetX = (target - 1) / 3;
        int targetY = (target - 1) % 3;
        
        return Math.abs(posX - targetX) + Math.abs(posY - targetY);
    }
}
