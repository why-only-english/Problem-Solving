class Solution {
    public String solution(int a, int b) {
        
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        // 1월은 for문은 돌지만 total에는 누적 안되게 0으로 설정
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        
        int total = 0;
        
        for(int i = 0; i < a; i++) {
            total += months[i];
        }
        total += b;
        
        // 1월 1월 금요일 => 4 더하고 7로 나눈 나머지
        return days[(total + 4) % 7];
    }
}