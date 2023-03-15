class Solution {
    public int solution(int n) {
        int pp = 0;
        int p = 1; 
        int result = 0;
        
        for (long i = 2; i <= n; i++) {
            result = (pp + p) % 1234567;
            pp = p % 1234567;
            p = result % 1234567;
        }
        
        return result;
    }
}