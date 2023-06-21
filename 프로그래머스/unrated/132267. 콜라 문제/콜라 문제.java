class Solution {
    public int solution(int a, int b, int n) {
        int cnt = 0;
        
        while (n >= a) {
            cnt += n / a * b;   // 콜라
            n = (n / a * b) + (n % a);   // 빈 병 
        }
        
        return cnt;
    }
}