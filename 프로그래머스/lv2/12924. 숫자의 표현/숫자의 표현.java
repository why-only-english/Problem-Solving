class Solution {
    public int solution(int x) {
        int answer = 0;
        
        for (int i = 1; i <= x; i++) {
            int sum = 0;   // 초기화 for문 안에서
            for (int j = i; j <= x; j++) {
                sum += j;
                // System.out.println(j);
                
                if (sum == x) {
                    answer++;
                    break;
                }
                else if (sum > x) {
                    break;
                }
            }
        }
        return answer;
    }
}