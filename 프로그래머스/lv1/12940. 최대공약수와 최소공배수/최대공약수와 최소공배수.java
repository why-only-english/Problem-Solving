class Solution {
    public int[] solution(int n, int m) {
        int a = Math.max(n, m);
        int b = Math.min(n, m);
        
        // 유클리드 호제법
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        
        int[] answer = {a, n * m / a};
        
        return answer;
    }
}