class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        String left = "";
        String right = "";
        
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < (food[i] / 2); j++) {
                left += i;            
            }
        }
        
        // 반복문 i값 인덱스 확인
        for (int k = left.length() - 1; k >= 0; k--) {
            right += Character.toString(left.charAt(k));
        }
        
        // System.out.println(left.charAt(1));
        answer = left + "0" + right;
        return answer;
    }
}